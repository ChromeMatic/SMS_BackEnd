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

        try{
            if(classSession == null){
                log.info("Object not found");
            }
        }catch (Error error){
            log.error("",error);
        }

        return classSession;
    }

    @Override
    public ClassSession FindClassSessionByName(String name) {


        ClassSession classSession = classSessionRepository.findByClassName(name);

        try{
            if(classSession == null){
                log.info("Object not found");
            }
        }catch (Error error){
            log.error("",error);
        }

        return classSession;
    }

    @Override
    public ClassSession AddNewClassSession(ClassSession classSession) {

      ClassSession classSession1 = classSessionRepository.findByClassName(classSession.getClassName());

      try{

      }catch (Error error){

      }

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
