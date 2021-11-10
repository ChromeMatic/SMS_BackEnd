package com.schManSys.sms.repository;

import com.schManSys.sms.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

    Course findByCourseId(Long courseId);
    Course findByCourseName( String courseName);
}
