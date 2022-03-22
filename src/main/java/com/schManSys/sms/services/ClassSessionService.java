package com.schManSys.sms.services;

import com.schManSys.sms.models.ClassSession;
import javassist.NotFoundException;

import java.util.List;

public interface ClassSessionService {

    ClassSession FindClassSessionById(Long classSessionId) throws NotFoundException;
    ClassSession FindClassSessionByName(String name)  throws NotFoundException;
    ClassSession AddNewClassSession(ClassSession classSession);
    ClassSession EditClassSession(Long ID, ClassSession classSession);
    List<ClassSession> getAllClassSessions();
}
