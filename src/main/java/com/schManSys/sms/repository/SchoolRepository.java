package com.schManSys.sms.repository;

import com.schManSys.sms.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Long> {

    School findBySchoolId (Long schoolId);
    School findBySchoolName (String schoolName);
}
