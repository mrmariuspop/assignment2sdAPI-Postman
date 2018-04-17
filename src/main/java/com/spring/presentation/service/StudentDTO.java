package com.spring.presentation.service;

import java.io.Serializable;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public class StudentDTO implements Serializable {

    private String email;
    private String fullname;
    private Long grupa;
    private String hobby;
    private String token;

    public StudentDTO() {
    }

    public StudentDTO(String email, String fullname, Long grupa, String hobby, String token) {
        this.email = email;
        this.fullname = fullname;
        this.grupa = grupa;
        this.hobby = hobby;
        this.token = token;
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
        this.token = token;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", grupa='" + grupa + '\'' +
                ", hobby='" + hobby + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
