package com.spring.presentation.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Entity
@Table(name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LABORATORY_UID")
    private Long laboratoryUid;

    @Column(name = "NUMBER")
    private Long number;

    @Column(name = "DATE")
    private String date;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CURRICULA")
    private String curricula;

    @Column(name = "DESCRIPTION")
    private String description;

    public Laboratory() {
    }

    public Laboratory(Long number, String date, String title, String curricula, String description) {
        this.number = number;
        this.date = date;
        this.title = title;
        this.curricula = curricula;
        this.description = description;
    }

    public Long getLaboratoryUid() {
        return laboratoryUid;
    }

    public void setLaboratoryUid(Long laboratoryUid) {
        this.laboratoryUid = laboratoryUid;
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
        return "Laboratory{" +
                "laboratoryUid=" + laboratoryUid +
                ", number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", curricula='" + curricula + '\'' +
                ", description='" + description + '\'' +

                '}';
    }


}
