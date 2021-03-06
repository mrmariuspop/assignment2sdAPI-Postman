package com.spring.presentation.dao;


import com.spring.presentation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */
@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {

    Student findByEmailAndFullname(String email, String fullname);

    Student findByEmailAndToken(String email, String token);


    //List<Book> findBookByDateBefore(Date date);

}
