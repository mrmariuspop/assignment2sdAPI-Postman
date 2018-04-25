package com.spring.presentation.controller;

import com.spring.presentation.model.Assigment;
import com.spring.presentation.service.AssigmentDTO;
import com.spring.presentation.service.AssigmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@RestController
@RequestMapping("assignments")
public class AssignmentController {

    private final AssigmentService assigmentService;

    @Autowired
    public AssignmentController(AssigmentService assigmentService) {
        this.assigmentService = assigmentService;
    }

    @GetMapping("getAllAssignments")
    public List<Assigment> getAllAssignments() {
        try {
            return assigmentService.getAllAssignments();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getAssignmentById")
    public Assigment getAssignmentById(@RequestParam Long assignmentId) {
        try {
            return assigmentService.getAssignmentById(assignmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("saveAssignment")
    public Assigment saveAssignment(@RequestBody AssigmentDTO assigmentDTO) {
        try {
            return assigmentService.saveAssignment(assigmentDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateAssignment")
    public Assigment updateAssignment(@RequestParam Long assignmentId, @RequestBody AssigmentDTO assigmentDTO) {
        try {
            return assigmentService.updateAssignment(assignmentId, assigmentDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("deleteAssignmentById")
    public String deleteAssignmentById(Long assignmentId) {
        try {
            assigmentService.deleteAssignmentById(assignmentId);
            return "Assigment with id = " + assignmentId + " successful deleted!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
