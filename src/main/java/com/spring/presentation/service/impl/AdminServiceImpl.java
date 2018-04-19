package com.spring.presentation.service.impl;

import com.spring.presentation.dao.AdminDAO;
import com.spring.presentation.model.Admin;
import com.spring.presentation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminDAO adminDAO;

    @Autowired
    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public Admin getAdminByEmailAndPassword(String email, String password) {
        return adminDAO.findByEmailAndPassword(email,password);
    }


}
