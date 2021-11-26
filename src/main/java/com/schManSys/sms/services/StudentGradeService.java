package com.schManSys.sms.services;

import com.schManSys.sms.models.StudentGrades;
import java.util.List;

public interface StudentGradeService {

    StudentGrades AddNewStudentGrade(StudentGrades studentGrades);
    void EditStudentGrade(Long studentId, StudentGrades studentGrades);
    StudentGrades FindById (Long studentGradeId);
    List<StudentGrades> FindByStudentId (Long studentId);
    List<StudentGrades> FindStudentGradeByStudentName (String studentName);
}
