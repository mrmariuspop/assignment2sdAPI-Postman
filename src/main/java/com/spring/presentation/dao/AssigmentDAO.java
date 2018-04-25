package com.spring.presentation.dao;

import com.spring.presentation.model.Assigment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */
@Repository
public interface AssigmentDAO extends JpaRepository<Assigment, Long> {

    Assigment findByNameAndDeadline(String name, String deadline);

    //List<Book> findBookByDateBefore(Date date);

}
