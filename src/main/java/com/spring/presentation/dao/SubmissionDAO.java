package com.spring.presentation.dao;

import com.spring.presentation.model.Book;
import com.spring.presentation.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */
@Repository
@Transactional
public interface SubmissionDAO extends JpaRepository<Submission, Long> {

  //  Submission findByTitleAndAuthor(String title, String author);

    //List<Book> findBookByDateBefore(Date date);

    List<Submission> getSubmissionsByAssigment_assigmentUid(Long assigmentUid);

}
