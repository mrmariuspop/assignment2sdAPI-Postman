package com.spring.presentation.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Entity
@Table(name = "submission")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBMISSION_UID")
    private Long submissionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn  (name = "STUDENT_ID")
    private Student student;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ASSIGNMENT_ID")
    private Assigment assigment;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "GRADE")
    private Long grade;

    public Submission() {
    }

    public Submission(Student student, Assigment assigment, Date date, Long grade) {
        this.student = student;
        this.assigment = assigment;
        this.date = date;
        this.grade = grade;
    }

    public Long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assigment getAssignment() {
        return assigment;
    }

    public void setAssignment(Assigment assigment) {
        this.assigment = assigment;
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
        return "Submission{" +
                "submissionUid=" + submissionId +
                ", student='" + student + '\'' +
                ", assignment='" + assigment + '\'' +
                ", date='" + date + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }


}
