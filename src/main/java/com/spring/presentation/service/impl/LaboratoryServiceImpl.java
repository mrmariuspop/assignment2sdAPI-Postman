package com.spring.presentation.service.impl;

import com.spring.presentation.dao.BookDAO;
import com.spring.presentation.dao.LaboratoryDAO;
import com.spring.presentation.model.Book;
import com.spring.presentation.model.Laboratory;
import com.spring.presentation.service.BookDTO;
import com.spring.presentation.service.BookService;
import com.spring.presentation.service.LaboratoryDTO;
import com.spring.presentation.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    private final LaboratoryDAO laboratoryDAO;

    @Autowired
    public LaboratoryServiceImpl(LaboratoryDAO laboratoryDAO) {
        this.laboratoryDAO = laboratoryDAO;
    }

    public List<Laboratory> getAllLaboratories() {
        return laboratoryDAO.findAll();
    }

    public Laboratory getLaboratoryById(Long laboratoryId) {
        return laboratoryDAO.findOne(laboratoryId);
    }

    public Laboratory saveLaboratory(LaboratoryDTO laboratoryDTO) {
        Laboratory laboratoryToBeSaved = new Laboratory(laboratoryDTO.getNumber(), laboratoryDTO.getDate(), laboratoryDTO.getTitle(), laboratoryDTO.getCurricula(), laboratoryDTO.getDescription());

        if (laboratoryDAO.findByNumberAndTitle(laboratoryToBeSaved.getNumber(), laboratoryToBeSaved.getTitle()) == null) {

            laboratoryDAO.save(laboratoryToBeSaved);
            return laboratoryDAO.findByNumberAndTitle(laboratoryDTO.getNumber(), laboratoryDTO.getTitle());

        } else {
            return null;
        }
    }

    public Laboratory updateLaboratory(Long laboratoryId, LaboratoryDTO laboratoryDTO) {
        Laboratory laboratoryToBeSaved = laboratoryDAO.findOne(laboratoryId);

        if (laboratoryToBeSaved != null) {
            laboratoryToBeSaved.setNumber(laboratoryDTO.getNumber());
            laboratoryToBeSaved.setDate(laboratoryDTO.getDate());
            laboratoryToBeSaved.setTitle(laboratoryDTO.getTitle());
            laboratoryToBeSaved.setCurricula(laboratoryDTO.getCurricula());
            laboratoryToBeSaved.setDescription(laboratoryDTO.getDescription());

            laboratoryDAO.save(laboratoryToBeSaved);
            return laboratoryToBeSaved;
        } else {
            return null;
        }
    }

    public void deleteLaboratoryById(Long laboratoryId) {
        laboratoryDAO.delete(laboratoryId);
    }
}
