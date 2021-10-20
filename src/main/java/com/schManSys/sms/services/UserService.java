package com.schManSys.sms.services;

import com.schManSys.sms.models.AppUser;
import com.schManSys.sms.models.Roles;

import java.util.List;

public interface UserService {

    AppUser AddNewUser (AppUser user);
    Roles AddNewRole (Roles roles);
    void AddRoleToUser (String username, String roleName);
    AppUser getUserById (Long userId);
    AppUser getUserByUsername (String username);
    List<AppUser> getUser();
}
