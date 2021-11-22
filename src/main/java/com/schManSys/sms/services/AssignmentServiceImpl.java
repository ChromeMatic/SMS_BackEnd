package com.schManSys.sms.services;

import com.schManSys.sms.models.Assignment;
import com.schManSys.sms.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Override
    public Assignment AddNewAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment FindByAssignmentId(Long assignmentId) {
        return assignmentRepository.findByAssignmentID(assignmentId);
    }

    @Override
    public Assignment FindByAssignmentName(String assignmentId) {
        return assignmentRepository.findByAssignmentNme(assignmentId);
    }

    @Override
    public Assignment EditAssignment(Long assignmentId, Assignment assignment) {
        return null;
    }

    @Override
    public List<Assignment> getAssignments() {
        return assignmentRepository.findAll();
    }
}
