package com.spring.presentation.dao;

import com.spring.presentation.model.Assignment;
import com.spring.presentation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */
@Repository
public interface AssignmentDAO extends JpaRepository<Assignment, Long> {

    Assignment findByNameAndDeadline(String name, String deadline);

    //List<Book> findBookByDateBefore(Date date);

}
