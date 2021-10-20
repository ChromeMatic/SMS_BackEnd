package com.schManSys.sms.services;

import com.schManSys.sms.models.School;
import com.schManSys.sms.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SchoolServiceImpl implements SchoolService{

    private final SchoolRepository schoolRepository;

    @Override
    public School AddNewSchool(School school) {
        log.info("Adding new school to DB");
        return schoolRepository.save(school);
    }

    @Override
    public School FindSchoolById(Long schoolId) {
        return schoolRepository.findBySchoolId(schoolId);
    }

    @Override
    public School FindSchoolByName(String schoolName) {
        return schoolRepository.findBySchoolName(schoolName);
    }

    @Override
    public School EditSchoolById(Long schoolId, School school) {
        return null;
    }

    @Override
    public School EditSchoolByName(School schoolName, School school) {
        return null;
    }

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }
}
