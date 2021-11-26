package com.schManSys.sms.services;

import com.schManSys.sms.models.Course;
import com.schManSys.sms.models.CourseResources;
import com.schManSys.sms.models.Student;
import com.schManSys.sms.models.StudentReport;
import com.schManSys.sms.repository.CourseRepository;
import com.schManSys.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public Student AddNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student FindStudentById(Long studentId) {

        Student student = studentRepository.findByStudentId(studentId);

        return student;
    }

    @Override
    public Student FindStudentByName(String studentName) {
        return studentRepository.findByStudentName(studentName);
    }

    @Override
    public Course AddNewCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Student AddCourseToStudent(Long studentId,String course) {

        Student student = studentRepository.findByStudentId(studentId);
        Course course1 = courseRepository.findByCourseName(course);

        student.getCourses().add(course1);

        return student;
    }

    @Override
    public List<Course> getStudentCourses(Long studentId) {

        Student student = studentRepository.findByStudentId(studentId);

        return (List<Course>) student.getCourses();
    }

    @Override
    public List<CourseResources> getCourseResources(String s) {
        return null;
    }

    @Override
    public StudentReport getStudentReport(Student studentId) {
        return null;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}