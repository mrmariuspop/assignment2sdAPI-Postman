package com.spring.presentation.service;

import com.spring.presentation.model.Assignment;
import com.spring.presentation.model.Book;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public interface AssignmentService {

    List<Assignment> getAllAssignments();

    Assignment getAssignmentById(Long assignmentId);

    Assignment saveAssignment(AssignmentDTO assignmentDTO);

    Assignment updateAssignment(Long assignmentId, AssignmentDTO assignmentDTO);

    void deleteAssignmentById(Long assignmentId);
}
