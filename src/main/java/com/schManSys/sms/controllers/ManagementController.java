package com.schManSys.sms.controllers;

import com.schManSys.sms.exception.ApiRequestException;
import com.schManSys.sms.models.*;
import com.schManSys.sms.services.CourseService;
import com.schManSys.sms.services.SchoolService;
import com.schManSys.sms.services.StudentService;
import com.schManSys.sms.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("api/v1/management")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ManagementController {

    private final UserService userService;
    private final StudentService studentService;
    private final SchoolService schoolService;
    private final CourseService courseService;


    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUser(){
        return ResponseEntity.ok().body(userService.getUser());
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @GetMapping("/schools")
    public ResponseEntity<List<School>> getSchools(){
        return ResponseEntity.ok().body(schoolService.getSchools());
    }

   @GetMapping("/student/{studentID}")
   public ResponseEntity<Student>getStudentByID(@PathVariable(value = "studentID")Long studentID){

        Student student = studentService.FindStudentById(studentID);

       if(student == null){
           throw  new ApiRequestException("Student does not exist");
       }else {
           URI uri = URI.create(ServletUriComponentsBuilder
                   .fromCurrentContextPath()
                   .path("api/v1/management/student")
                   .toUriString());

           return ResponseEntity.created(uri).body(student);
       }
   }

    @GetMapping("/user/{userId}")
    public ResponseEntity<AppUser> getUserById(@PathVariable(value = "userId") Long userId){

        AppUser user = userService.getUserById(userId);

        if(user == null){
            throw new ApiRequestException("User does not exit");
        }else {

            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("api/v1/management//user/")
                    .toUriString());

            return ResponseEntity.created(uri).body(user);
        }
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<School> GetSchoolById(@PathVariable(value = "schoolId")Long schoolId){

        School school = schoolService.FindSchoolById(schoolId);

        if(school == null){
            throw new ApiRequestException("School does not exist");
        }else {
            return ResponseEntity.ok().body(school);
        }
    }

    @GetMapping("/schoolName/{schoolName}")
    public  ResponseEntity<School> GetSchoolByName(@PathVariable(value = "schoolName")String schoolName){

        School school = schoolService.FindSchoolByName(schoolName);

        if(school == null){
            throw new ApiRequestException("School not found");
        }else{
         return ResponseEntity.ok().body(school);
        }

    }

    @GetMapping("/schoolStudents/{schoolName}")
    public ResponseEntity<Collection<Student>> GetStudentsBySchoolName(@PathVariable(value = "schoolName")String schoolName){

        School school = schoolService.FindSchoolByName(schoolName);

        if(school == null){
            throw new ApiRequestException("School not found.");
        }else{
            return ResponseEntity.ok().body(school.getStudents());
        }
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser>SaveUser(@RequestBody AppUser user){

        AppUser user1 = userService.getUserByUsername(user.getUsername());


        if(user1 != null){
            throw new ApiRequestException("User already exist.");
        }else {
          URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/v1/management/user/save")
                    .toUriString());
          return ResponseEntity.created(uri).body(userService.AddNewUser(user));
        }

    }

    @PostMapping("/role/save")
    public ResponseEntity<Roles> saveRole(@RequestBody Roles roles){

        Roles roles1 = userService.FindRoleByName(roles.getRoleName());

        if (roles1 != null){
            throw new ApiRequestException("Role already exist.");
        }else {
            if(roles == null){
                throw new ApiRequestException("Role object is empty");
            }else{
                URI uri = URI.create(ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/api/v1/management/role/save")
                        .toUriString());

                return ResponseEntity.created(uri).body(userService.AddNewRole(roles));
            }
        }
    }

    @PostMapping("/teacher/save")
    public ResponseEntity<Teacher> AddNewTeacher(){
        return null;
    }

    @PostMapping("/student/save")
    public ResponseEntity<Student> SaveStudent(@RequestBody Student student){

       Student student1 = studentService.FindStudentByName(student.getStudentName());

       //Checks to see if Student Exist
       if(student1 != null){
           throw new ApiRequestException("Student already exist");
       }else {
          //Checks to see if student object is empty
         if(student == null){
           throw new ApiRequestException("Student object is empty");
         }else {

             URI uri =  URI.create(ServletUriComponentsBuilder
                     .fromCurrentContextPath()
                     .path("api/s1/student/save")
                     .toUriString());
             // Save student to DB.
             return ResponseEntity.created(uri).body(studentService.AddNewStudent(student));
         }
       }


    }


    @PostMapping("/school")
    public ResponseEntity<School> SaveSchool(@RequestBody School school){

       School school1 = schoolService.FindSchoolByName(school.getSchoolName());

       if(school1 != null){
           throw new ApiRequestException("School name "
                     +school1.getSchoolName()+
                     " already exist.");
       }else {
           if(school == null){
               throw new ApiRequestException("School object is empty");
           }else{
               URI uri = URI.create(ServletUriComponentsBuilder
                       .fromCurrentContextPath()
                       .path("api/v1/management/school")
                       .toUriString());

               return ResponseEntity.created(uri).body(schoolService.AddNewSchool(school));

           }
       }
    }


    @PostMapping("/AddCourse")
    public ResponseEntity<Course> SaveNewCourse(@RequestBody Course course){
        return ResponseEntity.ok().body(courseService.AddNewCourse(course));
    }

    @PutMapping("/role/AddToUser")
    public ResponseEntity<?> AddRoleToUser(@RequestBody UserForm form){
        userService.AddRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/school/AddStudent/{school}/{studentID}")
    public ResponseEntity<School> SaveStudentToSchool(@PathVariable(value = "school") String school,
                                                      @PathVariable(value = "studentID") Long studentID ){

      School school1 = schoolService.FindSchoolByName(school);
      Student student = studentService.FindStudentById(studentID);

      if (student == null && school1 == null){
          throw new ApiRequestException("Student and school does exist.");
      }else {
          if(student != null && school1 != null){
            throw new ApiRequestException("Student and school already exist.");
          }else {
              URI uri = URI.create(ServletUriComponentsBuilder
                      .fromCurrentContextPath()
                      .path("api/v1/management/school/AddStudent/")
                      .toUriString());

              return ResponseEntity.created(uri).body(schoolService.AddNewStudents(studentID,school));

          }
      }

    }

    @PutMapping("/student/AddCourse/{studentID}/{course}")
    public ResponseEntity<Student> GetCourseToStudent(@PathVariable(value = "studentID") Long studentID,
                                                      @PathVariable(value = "course") String course ){

        Student student = studentService.FindStudentById(studentID);
        Course course1 = courseService.FindCourseByName(course);

        if( student == null && course1 == null){
            throw new ApiRequestException("Either student or course does not exist");
        }else{
            return ResponseEntity.ok().body(studentService.AddCourseToStudent(studentID,course));
        }
    }

    @PutMapping("/EditCourse/{courseId}")
    public ResponseEntity<Course> edit(@PathVariable(value = "courseId") Long courseId, @RequestBody Course course){

       Course course1 = courseService.FindCourseById(courseId);

       if( course1 == null && course == null){
           throw  new ApiRequestException("Either course does not exist or course object is empty");
       }else {
           return ResponseEntity.ok().body(courseService.EditCourse(courseId,course));
       }
    }


}

@Data
class UserForm{
    private String username;
    private String roleName;
}
