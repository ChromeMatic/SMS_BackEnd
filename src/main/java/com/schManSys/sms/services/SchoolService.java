package com.schManSys.sms.services;

import com.schManSys.sms.models.School;

import java.util.List;

public interface SchoolService {

    School AddNewSchool(School school);
    School FindSchoolById(Long schoolId);
    School FindSchoolByName(String schoolName);
    School EditSchoolById(Long schoolId, School school);
    School EditSchoolByName(School schoolName, School school);
    List<School> getSchools();
}
