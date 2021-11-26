package com.schManSys.sms.services;

import com.schManSys.sms.models.ClassSession;
import com.schManSys.sms.repository.ClassSessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ClassSessionServiceImpl implements ClassSessionService{

    private final ClassSessionRepository classSessionRepository;

    @Override
    public ClassSession FindClassSessionById(Long classSessionId) {

        ClassSession classSession = classSessionRepository.findByClassSessionId(classSessionId);

        return classSession;
    }

    @Override
    public ClassSession FindClassSessionByName(String name) {

        ClassSession classSession = classSessionRepository.findByClassName(name);

        return classSession;
    }

    @Override
    public ClassSession AddNewClassSession(ClassSession classSession) {

      return classSessionRepository.save(classSession);
    }

    @Override
    public ClassSession EditClassSession(Long ID, ClassSession classSession) {
        return null;
    }

    @Override
    public List<ClassSession> getAllClassSessions() {
        return classSessionRepository.findAll();
    }
}
