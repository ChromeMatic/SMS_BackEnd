package com.schManSys.sms.repository;

import com.schManSys.sms.models.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassSessionRepository extends JpaRepository<ClassSession,Long> {

    ClassSession findByClassSessionId(Long classSessionId);
    ClassSession findByClassName(String className);
}
