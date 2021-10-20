package com.schManSys.sms.repository;

import com.schManSys.sms.models.StudentGrades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradesRepository extends JpaRepository<StudentGrades,Long> {

    StudentGrades findByStudentName (String studentName);
    StudentGrades findByStudentGradeId (Long studentGradeId);
}
