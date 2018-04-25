package com.spring.presentation.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Entity
@Table(name = "attendence")
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="ATTENDANCE_STUDENT" , joinColumns = {@JoinColumn(name="ATTENDANCE_ID")} , inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID")})
    private Set<Student> students = new HashSet<>();

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

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public String toString() {
        return "Attendence{" +
                "attendenceUid=" + attendenceUid +
                ", lab_id='" + laboratoryId + '\'' +
                '}';
    }


}
