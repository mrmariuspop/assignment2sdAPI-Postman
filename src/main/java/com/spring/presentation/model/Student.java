package com.spring.presentation.model;

import com.spring.presentation.service.Tokenizer;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_UID")
    private Long studentId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULLNAME")
    private String fullname;

    @Column(name = "GRUPA")
    private Long grupa;

    @Column(name = "HOBBY")
    private String hobby;

    @Column(name = "TOKEN")
    private String token;
/*
    @ManyToMany(mappedBy ="listStudents")
    private Set<Attendance> listAttendences = new HashSet<Attendance>();*/

    public Student() {
    }

    public Student(String email, String password, String fullname, Long grupa, String hobby, String token) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.grupa = grupa;
        this.hobby = hobby;
        this.token = token;
    }

    public Long getStudentUid() {
        return studentId;
    }

    public void setStudentUid(Long studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getGrupa() {
        return grupa;
    }

    public void setGrupa(Long grupa) {
        this.grupa = grupa;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = Tokenizer.getSaltString();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public Set<Attendance> getListAttendences() {
        return listAttendences;
    }

    public void setListAttendences(Set<Attendance> listAttendences) {
        this.listAttendences = listAttendences;
    }
*/
    @Override
    public String toString() {
        return "Student{" +
                "studentUid=" + studentId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", grupa='" + grupa + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }


}
