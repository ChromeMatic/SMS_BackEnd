package com.schManSys.sms.repository;

import com.schManSys.sms.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Long> {

    Roles  findByRoleId (Long roleId);
    Roles findByRoleName (String roleName);
}
