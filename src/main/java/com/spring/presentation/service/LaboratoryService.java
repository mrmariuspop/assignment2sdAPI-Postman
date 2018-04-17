package com.spring.presentation.service;

import com.spring.presentation.model.Laboratory;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public interface LaboratoryService {

    List<Laboratory> getAllLaboratories();

    Laboratory getLaboratoryById(Long laboratoryId);

    Laboratory saveLaboratory(LaboratoryDTO laboratoryDTO);

    Laboratory updateLaboratory(Long laboratoryId, LaboratoryDTO laboratoryDTO);

    void deleteLaboratoryById(Long laboratoryId);
}
