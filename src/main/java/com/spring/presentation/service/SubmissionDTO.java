package com.spring.presentation.service;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class SubmissionDTO implements Serializable {

    private Long student;
    private Long assignment;
    private Date date;
    private Long grade;

    public SubmissionDTO() {
    }

    public SubmissionDTO(Long student, Long assignment, Date date, Long grade) {
        this.student = student;
        this.assignment = assignment;
        this.date = date;
        this.grade = grade;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public Long getAssignment() {
        return assignment;
    }

    public void setAssignment(Long assignment) {
        this.assignment = assignment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "SubmissionDTO{" +

                ", student='" + student + '\'' +
                ", assignment='" + assignment + '\'' +
                ", date='" + date + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
