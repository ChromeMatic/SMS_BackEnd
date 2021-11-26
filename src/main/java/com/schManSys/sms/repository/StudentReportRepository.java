package com.schManSys.sms.repository;

import com.schManSys.sms.models.StudentReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReportRepository extends JpaRepository<StudentReport,Long> {

    StudentReport findByStudentGradeId (Long studentGradeId);

}
