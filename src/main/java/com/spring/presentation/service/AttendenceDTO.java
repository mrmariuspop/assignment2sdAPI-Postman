package com.spring.presentation.service;

import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class AttendenceDTO implements Serializable {


    private Long laboratoryId;

    public AttendenceDTO() {
    }

    public AttendenceDTO(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    @Override
    public String toString() {
        return "AttendenceDTO{" +
                "laboratoryId='" + laboratoryId + '\'' +
                '}';
    }
}
