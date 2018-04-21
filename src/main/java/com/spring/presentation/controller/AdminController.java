package com.spring.presentation.controller;

import com.spring.presentation.model.Admin;
import com.spring.presentation.model.Book;
import com.spring.presentation.service.AdminService;
import com.spring.presentation.service.BookDTO;
import com.spring.presentation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@RestController
@RequestMapping("admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("login")
    public Admin getAdminByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        try {
            return adminService.getAdminByEmailAndPassword(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
