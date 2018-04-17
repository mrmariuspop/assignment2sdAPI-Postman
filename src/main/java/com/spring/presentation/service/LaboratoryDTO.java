package com.spring.presentation.service;

import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class LaboratoryDTO implements Serializable {

    private Long number;
    private String date;
    private String title;
    private String curricula;
    private String description;

    public LaboratoryDTO() {
    }

    public LaboratoryDTO(Long number, String date, String title, String curricula, String description) {
        this.number = number;
        this.date = date;
        this.title = title;
        this.curricula = curricula;
        this.description = description;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurricula() {
        return curricula;
    }

    public void setCurricula(String curricula) {
        this.curricula = curricula;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LaboratoryDTO{" +
                "number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", curricula='" + curricula + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
