package com.spring.presentation.dao;

import com.spring.presentation.model.Admin;
import com.spring.presentation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */
@Repository
public interface AdminDAO extends JpaRepository<Admin, Long> {

    Admin findByEmailAndPassword(String email, String password);

    //List<Book> findBookByDateBefore(Date date);

}
