package com.spring.presentation.service;

import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class AssigmentDTO implements Serializable {

    private String name;
    private String deadline;
    private String description;
    private Long laboratoryId;

    public AssigmentDTO() {
    }

    public AssigmentDTO(String name, String deadline, String description) {
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AssigmentDTO{" +
                "name='" + name + '\'' +
                ", deadline='" + deadline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
