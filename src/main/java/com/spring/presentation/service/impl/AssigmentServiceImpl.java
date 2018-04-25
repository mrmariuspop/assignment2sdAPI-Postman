package com.spring.presentation.service.impl;

import com.spring.presentation.dao.AssigmentDAO;
import com.spring.presentation.dao.LaboratoryDAO;
import com.spring.presentation.model.Assigment;
import com.spring.presentation.model.Laboratory;
import com.spring.presentation.service.AssigmentDTO;
import com.spring.presentation.service.AssigmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Service
public class AssigmentServiceImpl implements AssigmentService {

    private final AssigmentDAO assigmentDAO;
    private final LaboratoryDAO laboratoryDAO;

    @Autowired
    public AssigmentServiceImpl(AssigmentDAO assigmentDAO, LaboratoryDAO laboratoryDAO) {
        this.assigmentDAO = assigmentDAO;
        this.laboratoryDAO = laboratoryDAO;
    }

    public List<Assigment> getAllAssignments() {
        return assigmentDAO.findAll();
    }

    public Assigment getAssignmentById(Long assignmentId) {
        return assigmentDAO.findOne(assignmentId);
    }

    public Assigment saveAssignment(AssigmentDTO assigmentDTO) {
        Laboratory lab1 = laboratoryDAO.findOne(assigmentDTO.getLaboratoryId());
        Assigment assigmentToBeSaved = new Assigment(assigmentDTO.getName(), assigmentDTO.getDeadline(), assigmentDTO.getDescription() );
        assigmentToBeSaved.setLaboratory(lab1);
        if (assigmentDAO.findByNameAndDeadline(assigmentToBeSaved.getName(), assigmentToBeSaved.getDeadline()) == null) {

            assigmentDAO.save(assigmentToBeSaved);
            return assigmentDAO.findByNameAndDeadline(assigmentDTO.getName(), assigmentDTO.getDeadline());

        } else {
            return null;
        }
    }

    public Assigment updateAssignment(Long assignmentId, AssigmentDTO assigmentDTO) {
        Assigment assigmentToBeUpdated = assigmentDAO.findOne(assignmentId);

        if (assigmentToBeUpdated != null) {
            assigmentToBeUpdated.setName(assigmentDTO.getName());
            assigmentToBeUpdated.setDeadline(assigmentDTO.getDeadline());
            assigmentToBeUpdated.setDescription(assigmentDTO.getDescription());


            assigmentDAO.save(assigmentToBeUpdated);
            return assigmentToBeUpdated;
        } else {
            return null;
        }
    }

    public void deleteAssignmentById(Long assignmentId) {
        assigmentDAO.delete(assignmentId);
    }
}
