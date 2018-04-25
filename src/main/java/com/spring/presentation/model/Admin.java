package com.spring.presentation.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADMIN_UID")
    private Long adminUid;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    public Admin() {
    }

    public Admin(String email, String passwordr) {
        this.email = email;
        this.password = passwordr;
    }


    public void setAdminUid(Long adminUid) {
        this.adminUid = adminUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminUid=" + adminUid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
