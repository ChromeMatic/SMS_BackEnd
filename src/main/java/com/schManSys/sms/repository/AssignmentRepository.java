package com.schManSys.sms.repository;

import com.schManSys.sms.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {

    Assignment findByAssignmentID(Long assignmentID);
    Assignment findByAssignmentNme(String assignmentNme);
}
