package com.schManSys.sms.repository;

import com.schManSys.sms.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByStudentId (Long studentId);
    Student findByStudentName (String studentName);
}
