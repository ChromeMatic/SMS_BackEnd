package com.schManSys.sms.services;

import com.schManSys.sms.models.Assignment;

import java.util.List;

public interface AssignmentService {

    Assignment AddNewAssignment(Assignment assignment);
    Assignment FindByAssignmentId(Long assignmentId);
    Assignment FindByAssignmentName(String assignmentId);
    Assignment EditAssignment(Long assignmentId, Assignment assignment);
    List<Assignment> getAssignments();
}
