package com.spring.presentation.controller;

import com.spring.presentation.model.Laboratory;
import com.spring.presentation.service.LaboratoryDTO;
import com.spring.presentation.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@RestController
@RequestMapping("laboratories")
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    @Autowired
    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @GetMapping("getAllLaboratories")
    public List<Laboratory> getAllLaboratories() {
        try {
            return laboratoryService.getAllLaboratories();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getLaboratoryById")
    public Laboratory getLaboratoryById(@RequestParam Long laboratoryId) {
        try {
            return laboratoryService.getLaboratoryById(laboratoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("saveLaboratory")
    public Laboratory saveLaboratory(@RequestBody LaboratoryDTO laboratoryDTO) {
        try {
            return laboratoryService.saveLaboratory(laboratoryDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateLaboratory")
    public Laboratory updateLaboratory(@RequestParam Long laboratoryId, @RequestBody LaboratoryDTO laboratoryDTO) {
        try {
            return laboratoryService.updateLaboratory(laboratoryId, laboratoryDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("deleteLaboratoryById")
    public String deleteLaboratoryById(Long laboratoryId) {
        try {
            laboratoryService.deleteLaboratoryById(laboratoryId);
            return "Laboratory with id = " + laboratoryId + " successful deleted!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
