package com.spring.presentation.dao;

import com.spring.presentation.model.Attendance;
import com.spring.presentation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */
@Repository
public interface AttendenceDAO extends JpaRepository<Attendance, Long> {

    Attendance findByLaboratoryId(Long laboratoryId);

    //List<Book> findBookByDateBefore(Date date);

}
