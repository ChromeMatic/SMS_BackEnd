package com.schManSys.sms.controllers;

import com.schManSys.sms.models.AppUser;
import com.schManSys.sms.models.Roles;
import com.schManSys.sms.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/management")
@RequiredArgsConstructor
public class ManagementController {

    private final UserService userService;

    // hasRole('ROLE'), hasAnyRole('ROLE'), hasAuthority('permission') hasAuthority('permission)

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AppUser>>getUser(){
        return ResponseEntity.ok().body(userService.getUser());
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

    @PostMapping("/role/AddToUser")
    public ResponseEntity<?> AddRoleToUser(@RequestBody UserForm form){
        userService.AddRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class UserForm{
    private String username;
    private String roleName;
}
