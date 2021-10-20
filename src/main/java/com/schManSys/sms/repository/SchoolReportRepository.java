package com.schManSys.sms.repository;

import com.schManSys.sms.models.SchoolReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolReportRepository extends JpaRepository<SchoolReport,Long> {

    SchoolReport findBySchoolReportId (Long schoolReportId);
    SchoolReport findBySchoolName (String schoolName);
}
