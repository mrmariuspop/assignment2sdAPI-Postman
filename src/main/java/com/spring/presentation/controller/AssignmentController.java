package com.spring.presentation.controller;

import com.spring.presentation.model.Assignment;
import com.spring.presentation.service.AssignmentDTO;
import com.spring.presentation.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@RestController
@RequestMapping("assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("getAllAssignments")
    public List<Assignment> getAllAssignments() {
        try {
            return assignmentService.getAllAssignments();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getAssignmentById")
    public Assignment getAssignmentById(@RequestParam Long assignmentId) {
        try {
            return assignmentService.getAssignmentById(assignmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("saveAssignment")
    public Assignment saveAssignment(@RequestBody AssignmentDTO assignmentDTO) {
        try {
            return assignmentService.saveAssignment(assignmentDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateAssignment")
    public Assignment updateAssignment(@RequestParam Long assignmentId, @RequestBody AssignmentDTO assignmentDTO) {
        try {
            return assignmentService.updateAssignment(assignmentId, assignmentDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("deleteAssignmentById")
    public String deleteAssignmentById(Long assignmentId) {
        try {
            assignmentService.deleteAssignmentById(assignmentId);
            return "Assignment with id = " + assignmentId + " successful deleted!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
