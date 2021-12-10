package com.schManSys.sms.controllers;

import com.schManSys.sms.exception.ApiRequestException;
import com.schManSys.sms.models.*;
import com.schManSys.sms.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class TeacherController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final CourseService  courseService;
    private final AssignmentService assignmentService;
    private final StudentGradeService studentGradeService;

    @GetMapping("/")
    public List<Teacher> getTeachers(){
        return  teacherService.getAllTeacher();
    }

    @GetMapping("/getStudentById/{studentId}")
    private ResponseEntity<Student> getStudent(@PathVariable(value = "studentId") Long studentId){

        Student student = studentService.FindStudentById(studentId);

        if( student == null){
            throw new ApiRequestException("Student Does not exist.");
        }else {
            return ResponseEntity.ok().body(student);
        }

    }

    @GetMapping("/getStudent/{studentName}")
    private ResponseEntity<Student> getStudentByName(@PathVariable("studentName") String studentName){

        Student student = studentService.FindStudentByName(studentName);

        if( student == null){
            throw new ApiRequestException("Student Does not exist.");
        }else{
            return ResponseEntity.ok().body(student);
        }

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


    @PostMapping("/AddAssignment")
    public ResponseEntity<Assignment> AddAssignment(@RequestBody Assignment assignment){

        Assignment assignment1 = assignmentService.FindByAssignmentName(assignment.getAssignmentNme());

        if( assignment1 != null){
           throw new ApiRequestException("Assignment Already exist");
        }else{
            return ResponseEntity.ok().body(assignmentService.AddNewAssignment(assignment));
        }
    }


    @PostMapping("/EditReport/{studentId}")
    public ResponseEntity<Student> editStudentReport(@PathVariable(value = "studentId") Long studentId){

        Student student = studentService.FindStudentById(studentId);

        if( student == null){
            return ResponseEntity.notFound().build();
        }else{
            return  ResponseEntity.ok().body(student);
        }

    }


}
