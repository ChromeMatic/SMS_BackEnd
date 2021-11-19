package com.schManSys.sms.services;

import com.schManSys.sms.models.Course;
import javassist.NotFoundException;

import java.util.List;

public interface CourseService {

    Course AddNewCourse(Course course);
    Course FindCourseById(Long courseId) throws NotFoundException;
    Course FindCourseByName(String course) throws NotFoundException;
    Course EditCourse(Long courseId,Course course);
    List<Course> getAllCourse();
}
