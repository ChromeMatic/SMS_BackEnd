package com.schManSys.sms.services;

import com.schManSys.sms.models.StudentGrades;
import java.util.Collection;

public interface StudentGradeService {

    StudentGrades AddNewStudentGrade(StudentGrades studentGrades);
    void EditStudentGrade(Long studentId, StudentGrades studentGrades);
    StudentGrades FindById (Long studentGradeId);
    Collection<StudentGrades> FindStudentGradeByStudentName (String studentName);
}
