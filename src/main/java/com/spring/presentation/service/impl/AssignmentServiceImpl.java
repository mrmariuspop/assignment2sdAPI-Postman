package com.spring.presentation.service.impl;

import com.spring.presentation.dao.AssignmentDAO;
import com.spring.presentation.model.Assignment;
import com.spring.presentation.service.AssignmentDTO;
import com.spring.presentation.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentDAO assignmentDAO;

    @Autowired
    public AssignmentServiceImpl(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    public List<Assignment> getAllAssignments() {
        return assignmentDAO.findAll();
    }

    public Assignment getAssignmentById(Long assignmentId) {
        return assignmentDAO.findOne(assignmentId);
    }

    public Assignment saveAssignment(AssignmentDTO assignmentDTO) {
        Assignment assignmentToBeSaved = new Assignment(assignmentDTO.getName(), assignmentDTO.getDeadline(), assignmentDTO.getDescription() );

        if (assignmentDAO.findByNameAndDeadline(assignmentToBeSaved.getName(), assignmentToBeSaved.getDeadline()) == null) {

            assignmentDAO.save(assignmentToBeSaved);
            return assignmentDAO.findByNameAndDeadline(assignmentDTO.getName(), assignmentDTO.getDeadline());

        } else {
            return null;
        }
    }

    public Assignment updateAssignment(Long assignmentId, AssignmentDTO assignmentDTO) {
        Assignment assignmentToBeUpdated = assignmentDAO.findOne(assignmentId);

        if (assignmentToBeUpdated != null) {
            assignmentToBeUpdated.setName(assignmentDTO.getName());
            assignmentToBeUpdated.setDeadline(assignmentDTO.getDeadline());
            assignmentToBeUpdated.setDescription(assignmentDTO.getDescription());


            assignmentDAO.save(assignmentToBeUpdated);
            return assignmentToBeUpdated;
        } else {
            return null;
        }
    }

    public void deleteAssignmentById(Long assignmentId) {
        assignmentDAO.delete(assignmentId);
    }
}
