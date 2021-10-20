package com.schManSys.sms.services;

import com.schManSys.sms.models.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher SaveNewTeacher(Teacher teacher);
    Teacher getTeacherById (Long teacherId);
    Teacher getTeacherByName (String teacherName);
    List<Teacher> getAllTeacher();
}
