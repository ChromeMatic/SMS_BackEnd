package com.schManSys.sms.services;

import com.schManSys.sms.models.Student;

import java.util.List;

public interface StudentService {

    Student AddNewStudent (Student student);
    Student FindStudentById (Long studentId);
    Student FindStudentByName (String studentName);
    List<Student> getStudents();
}
