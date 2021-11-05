package com.schManSys.sms.controllers;

import com.schManSys.sms.models.Course;
import com.schManSys.sms.models.Student;
import com.schManSys.sms.models.StudentGrades;
import com.schManSys.sms.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/courses/{studentId}")
    public ResponseEntity<List<Course>> getStudentCourses(@PathVariable(value = "studentId") Long studentId){

        Student student =  studentService.FindStudentById(studentId);

        List<Course> studentCourses = student.getCourses();

        return ResponseEntity.ok().body(studentCourses);
    }

    @GetMapping("/StudentGrades/{studentId}")
    public  ResponseEntity<List<StudentGrades>> getGrades(@PathVariable(value = "studentId") Long studentId) {

        Student student = studentService.FindStudentById(studentId);

        List<StudentGrades> grades = student.getGradesSet();

        return ResponseEntity.ok().body(grades);
    }

    @GetMapping("/Student/{}")
    public ResponseEntity<?> getStudentReport(@PathVariable(value = "") Long placeHolder){
        return null;
    }

}
