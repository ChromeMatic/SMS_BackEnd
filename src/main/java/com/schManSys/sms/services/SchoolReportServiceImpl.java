package com.schManSys.sms.services;

import com.schManSys.sms.models.School;
import com.schManSys.sms.models.SchoolReport;
import com.schManSys.sms.repository.SchoolReportRepository;
import com.schManSys.sms.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static java.util.Objects.isNull;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SchoolReportServiceImpl implements SchoolReportService {

    private final SchoolRepository schoolRepository;
    private final SchoolReportRepository schoolReportRepository;

    @Override
    public SchoolReport AddNewSchoolReport(SchoolReport schoolReport) {
        log.info("Add new School report to DB");
        return schoolReportRepository.save(schoolReport);
    }

    @Override
    public SchoolReport FindSchoolReport(Long schoolReportId) {
        log.info("Finding School Report by ID");
        return schoolReportRepository.findBySchoolReportId(schoolReportId);
    }

    @Override
    public SchoolReport FindSchoolReportByName(String schoolName) {
        log.info("Finding School Report by School name");
        return schoolReportRepository.findBySchoolName(schoolName);
    }

    @Override
    public void EditSchoolReport(Long schoolId, SchoolReport schoolReport) {

        School school = schoolRepository.findBySchoolId(schoolId);

        if(isNull(school)){
            log.error("school does not exist");
        }

        school.getSchoolReport().add(schoolReport);
    }

    @Override
    public List<SchoolReport> getAllSchoolReports() {
        return schoolReportRepository.findAll();
    }
}