package com.schManSys.sms.controllers;

import com.schManSys.sms.models.*;
import com.schManSys.sms.services.AssignmentService;
import com.schManSys.sms.services.ClassSessionService;
import com.schManSys.sms.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/s1")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;
    private final ClassSessionService classSessionService;
    private final AssignmentService assignmentService;

    @GetMapping("/courses/{studentId}")
    public ResponseEntity<Collection<Course>> getStudentCourses(@PathVariable(value = "studentId") Long studentId){

        Student student =  studentService.FindStudentById(studentId);

        Collection<Course> studentCourses = student.getCourses();

        return ResponseEntity.ok().body(studentCourses);
    }

    @GetMapping("/StudentGrades/{studentId}")
    public  ResponseEntity<List<StudentGrades>> getGrades(@PathVariable(value = "studentId") Long studentId) {

        Student student = studentService.FindStudentById(studentId);

        List<StudentGrades> grades = student.getGradesSet();

        return ResponseEntity.ok().body(grades);
    }

    /*
    * @GetMapping("/StudentReport/{}")
    public ResponseEntity<?> getStudentReport(@PathVariable(value = "") Long placeHolder){
        return null;
    }
    * */

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "studentId") Long studentId){

        Student student = studentService.FindStudentById(studentId);

        try{
           if (student == null){
               return ResponseEntity.notFound().build();
           }
        }catch (Error error){
            log.error("Entity not found",error);
        }

        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/student/classes")
    public ResponseEntity<List<ClassSession>> getClassSession(){
        return ResponseEntity.ok().body(classSessionService.getAllClassSessions());
    }

    @GetMapping("/student/Assignments")
    public ResponseEntity<List<Assignment>> getAssignments(){
        return ResponseEntity.ok().body(assignmentService.getAssignments());
    }

}
