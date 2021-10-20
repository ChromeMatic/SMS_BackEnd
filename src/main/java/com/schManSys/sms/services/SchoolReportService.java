package com.schManSys.sms.services;

import com.schManSys.sms.models.SchoolReport;

import java.util.List;

public interface SchoolReportService {

    SchoolReport AddNewSchoolReport(SchoolReport schoolReport);
    SchoolReport FindSchoolReport(Long schoolReportId);
    SchoolReport FindSchoolReportByName(String schoolName);
    void EditSchoolReport(Long schoolId, SchoolReport schoolReport);
    List<SchoolReport> getAllSchoolReports();

}
