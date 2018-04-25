package com.spring.presentation.service;

import com.spring.presentation.model.Assigment;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public interface AssigmentService {

    List<Assigment> getAllAssignments();

    Assigment getAssignmentById(Long assignmentId);

    Assigment saveAssignment(AssigmentDTO assigmentDTO);

    Assigment updateAssignment(Long assignmentId, AssigmentDTO assigmentDTO);

    void deleteAssignmentById(Long assignmentId);


}
