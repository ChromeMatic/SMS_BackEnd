package com.schManSys.sms.controllers;

import com.schManSys.sms.models.*;
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
import java.util.List;

@RestController
@RequestMapping("api/v1/management")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class ManagementController {

    private final UserService userService;
    private final StudentService studentService;
    private final SchoolService schoolService;

    // hasRole('ROLE'), hasAnyRole('ROLE'), hasAuthority('permission')
    // hasAuthority('permission) @PreAuthorize("hasRole('ROLE_ADMIN')")

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUser(){
        return ResponseEntity.ok().body(userService.getUser());
    }

   @GetMapping("/student/{studentID}")
   public ResponseEntity<Student>getStudentByID(@PathVariable(value = "studentID")Long studentID){

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("")
                .toUriString());

        return ResponseEntity.created(uri).body(studentService.FindStudentById(studentID));
   }

    @GetMapping("/user/{userId}")
    public ResponseEntity<AppUser> getUserById(@PathVariable(value = "userId") Long userId){
        AppUser user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser>SaveUser(@RequestBody AppUser user){
        URI uri = URI.create(ServletUriComponentsBuilder
                  .fromCurrentContextPath()
                  .path("/api/v1/management/user/save")
                  .toUriString());
        return ResponseEntity.created(uri).body(userService.AddNewUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Roles> saveRole(@RequestBody Roles roles){
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/v1/management/role/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.AddNewRole(roles));
    }

    @PutMapping("/role/AddToUser")
    public ResponseEntity<?> AddRoleToUser(@RequestBody UserForm form){
        userService.AddRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/teacher/save")
    public ResponseEntity<Teacher> AddNewTeacher(){
        return null;
    }

    @PostMapping("/student/save")
    public ResponseEntity<Student> SaveStudent(@RequestBody Student student){

        URI uri =  URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("api/s1/student/save")
                .toUriString());

        return ResponseEntity.created(uri).body(studentService.AddNewStudent(student));
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<School> GetSchoolById(@PathVariable(value = "schoolId")Long schoolId){
        return ResponseEntity.ok().body(schoolService.FindSchoolById(schoolId));
    }

    @PostMapping("/school")
    public ResponseEntity<School> SaveSchool(@RequestBody School school){

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("api/v1/management/school")
                .toUriString());

        return ResponseEntity.created(uri).body(schoolService.AddNewSchool(school));
    }

    @PutMapping("/school/AddStudent/{school}/{studentID}")
    public ResponseEntity<School> SaveStudentToSchool(@PathVariable(value = "school") String school,
                                                      @PathVariable(value = "studentID") Long studentID ){

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("api/v1/management/school/AddStudent/")
                .toUriString());

        return ResponseEntity.created(uri).body(schoolService.AddNewStudents(studentID,school));
    }
}

@Data
class UserForm{
    private String username;
    private String roleName;
}
