package com.spring.presentation.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Entity
@Table(name = "attendences")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ATTENDENCE_UID")
    private Long attendenceUid;

    @Column(name = "LABORATORY_ID")
    private Long laboratoryId;


    public Attendance() {
    }

    public Attendance(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public Long getAttendenceUid() {
        return attendenceUid;
    }

    public void setAttendenceUid(Long attendenceUid) {
        this.attendenceUid = attendenceUid;
    }

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    @Override
    public String toString() {
        return "Attendence{" +
                "attendenceUid=" + attendenceUid +
                ", lab_id='" + laboratoryId + '\'' +
                '}';
    }


}
