package com.spring.presentation.service;

import com.spring.presentation.model.Admin;
import com.spring.presentation.model.Book;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public interface AdminService {

    Admin getAdminByEmailAndPassword(String email, String password);

}
