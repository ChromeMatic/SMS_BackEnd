package com.schManSys.sms.repository;

import com.schManSys.sms.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUserId (Long userId);
    AppUser findByUsername (String username);
}
