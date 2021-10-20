package com.schManSys.sms.controllers;

import com.schManSys.sms.models.Teacher;
import com.schManSys.sms.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeachers(){
        return  teacherService.getAllTeacher();
    }
}
