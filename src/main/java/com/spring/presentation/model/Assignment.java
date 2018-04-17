package com.spring.presentation.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSIGNMENT_UID")
    private Long assignmentUid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DEADLINE")
    private String deadline;

    @Column(name = "DESCRIPTION")
    private String description;

    public Assignment() {
    }

    public Assignment(String name, String deadline, String description) {
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }

    public Long getAssignmentUid() {
        return assignmentUid;
    }

    public void setAssignmentUid(Long assignmentUid) {
        this.assignmentUid = assignmentUid;
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
        return "Assignment{" +
                "AssignmentUid=" + assignmentUid +
                ", name='" + name + '\'' +
                ", deadline='" + deadline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
