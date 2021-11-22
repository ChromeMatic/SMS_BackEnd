package com.schManSys.sms.services;

import com.schManSys.sms.models.ClassSession;

import java.util.List;

public interface ClassSessionService {

    ClassSession FindClassSessionById(Long classSessionId);
    ClassSession FindClassSessionByName(String name);
    ClassSession AddNewClassSession(ClassSession classSession);
    ClassSession EditClassSession(Long ID, ClassSession classSession);
    List<ClassSession> getAllClassSessions();
}
