package com.schManSys.sms.services;

import com.schManSys.sms.models.AppUser;
import com.schManSys.sms.models.Roles;
import com.schManSys.sms.repository.RoleRepository;
import com.schManSys.sms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServicesImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        AppUser user = userRepository.findByUsername(username);

        //Checks to see if username exist.
        if(user == null){
            log.error("User not found in DB");
            throw new UsernameNotFoundException("User not found in DB");
        }else{
            log.info("User found in DB: {}",username);

        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
        });

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public AppUser AddNewUser(AppUser user) {
        log.info("Add new user to DB.");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Roles AddNewRole(Roles roles) {
        log.info("Add new Role to DB.");
        return roleRepository.save(roles);
    }

    @Override
    public void AddRoleToUser(String username, String roleName) {
        log.info("Adding new role to user.");
       AppUser user = userRepository.findByUsername(username);
       Roles roles = roleRepository.findByRoleName(roleName);
       user.getRoles().add(roles);
    }

    @Override
    public AppUser getUserById(Long userId) {
        log.info("finding user by Id");
        return userRepository.findByUserId(userId);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        log.info("Finding user by username.");
        return  userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUser() {
        log.info("Getting all users");
        return userRepository.findAll();
    }
}
