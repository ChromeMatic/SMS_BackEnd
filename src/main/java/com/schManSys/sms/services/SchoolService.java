package com.schManSys.sms.services;

import com.schManSys.sms.models.School;
import com.schManSys.sms.models.Student;
import com.schManSys.sms.models.Teacher;

import java.util.List;

public interface SchoolService {

    School AddNewSchool(School school);
    School FindSchoolById(Long schoolId);
    School FindSchoolByName(String schoolName);
    School EditSchoolById(Long schoolId, School school);
    void EditSchoolByName(School schoolName, School school);
    School AddNewStudents(Long studentId,String schoolName);
    void AddNewTeacher(Teacher teacher);
    List<School> getSchools();
}
