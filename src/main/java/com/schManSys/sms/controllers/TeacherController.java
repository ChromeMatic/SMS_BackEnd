package com.schManSys.sms.controllers;

import com.schManSys.sms.models.Course;
import com.schManSys.sms.models.Student;
import com.schManSys.sms.models.Teacher;
import com.schManSys.sms.services.CourseService;
import com.schManSys.sms.services.StudentService;
import com.schManSys.sms.services.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
@Slf4j
public class TeacherController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final CourseService  courseService;

    @GetMapping("/")
    public List<Teacher> getTeachers(){
        return  teacherService.getAllTeacher();
    }

    @GetMapping("/getStudentById/{studentId}")
    private ResponseEntity<Student> getStudent(@PathVariable(value = "studentId") Long studentId){

        Student student = studentService.FindStudentById(studentId);

        try {
            if(student == null){
             return ResponseEntity.notFound().build();
            }
        }catch (Error error){
            log.error("Student Object is empty",error);
        }

        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/getStudent/{studentName}")
    private ResponseEntity<Student> getStudentByName(@PathVariable("studentName") String studentName){

        Student student = studentService.FindStudentByName(studentName);

        try{
            if (student == null){
                return ResponseEntity.notFound().build();
            }
        }catch (Error error){
            log.error("Student Entity not found :",error);
        }

        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/getCourses")
    public ResponseEntity<List<Course>> getCourses(){

        List<Course> coursesList = courseService.getAllCourse();

        return ResponseEntity.ok().body(coursesList);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @PostMapping("/EditReport/{studentId}")
    public ResponseEntity<Student> editStudentReport(@PathVariable(value = "studentId") Long studentId){

        return null;
    }
}
