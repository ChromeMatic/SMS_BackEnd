package com.schManSys.sms.services;

import com.schManSys.sms.models.Course;
import com.schManSys.sms.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements  CourseService{

    private final CourseRepository courseRepository;

    @Override
    public Course AddNewCourse(Course course) {
        log.info("Course added to DB");
        return courseRepository.save(course);
    }

    @Override
    public Course FindCourseById(Long courseId) {

        Course course = courseRepository.findByCourseId(courseId);

        return course;
    }

    @Override
    public Course FindCourseByName(String course) {

        Course course1 = courseRepository.findByCourseName(course);


        return course1;
    }

    @Override
    public Course EditCourse(Long courseId, Course course) {

        Course course2 = courseRepository.findByCourseId(courseId);

        course2.setCourseName(course.getCourseName());
        course2.setTeacherName(course.getTeacherName());
        course2.setTimeAndDate(course.getTimeAndDate());
        course2.setCourseResources(course.getCourseResources());

        return course2;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
}
