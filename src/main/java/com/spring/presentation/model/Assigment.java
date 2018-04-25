package com.spring.presentation.model;

import jdk.nashorn.internal.ir.Assignment;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Entity
@Table(name = "assigment")
public class Assigment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSIGNMENT_UID")
    private Long assigmentUid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DEADLINE")
    private String deadline;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "laboratoryId")
    private Laboratory laboratory;

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    @OneToMany(mappedBy = "assigment")
    private Set<Submission> assigmentStudent = new HashSet<>();


    public Assigment() {
    }

    public Assigment(String name, String deadline, String description) {
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }

    public Long getassigmentUid() {
        return assigmentUid;
    }

    public void setassigmentUid(Long assigmentUid) {
        this.assigmentUid = assigmentUid;
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

    public Set<Submission> getAssigmentStudent() {
        return assigmentStudent;
    }

    public void setAssigmentStudent(Set<Submission> assigmentStudent) {
        this.assigmentStudent = assigmentStudent;
    }

    @Override
    public String toString() {
        return "Assigment{" +
                "assigmentUid=" + assigmentUid +
                ", name='" + name + '\'' +
                ", deadline='" + deadline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
