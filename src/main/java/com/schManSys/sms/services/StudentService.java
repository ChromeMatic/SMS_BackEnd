package com.schManSys.sms.services;

import com.schManSys.sms.models.Course;
import com.schManSys.sms.models.CourseResources;
import com.schManSys.sms.models.Student;
import com.schManSys.sms.models.StudentReport;

import java.util.Collection;
import java.util.List;

public interface StudentService {

    Student AddNewStudent (Student student);
    Student FindStudentById (Long studentId);
    Student FindStudentByName (String studentName);
    Course AddNewCourse(Course course);
    Student   AddCourseToStudent (Long studentId,String course);
    List<Course> getStudentCourses(Long studentId);
    List<CourseResources> getCourseResources(String s);
    StudentReport getStudentReport (Student studentId);
    List<Student> getStudents();
}
