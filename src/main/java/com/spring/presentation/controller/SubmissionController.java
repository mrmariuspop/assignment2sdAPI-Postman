package com.spring.presentation.controller;

import com.spring.presentation.model.Book;
import com.spring.presentation.model.Submission;
import com.spring.presentation.service.BookDTO;
import com.spring.presentation.service.BookService;
import com.spring.presentation.service.SubmissionDTO;
import com.spring.presentation.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@RestController
@RequestMapping("submission")
public class SubmissionController {

    private final SubmissionService bookService;

    @Autowired
    public SubmissionController(SubmissionService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("getAllSubmissions")
    public List<SubmissionDTO> getAllSubmissions() {

            return bookService.getAllSubmissions();

    }

    @GetMapping("getSubmissionById")
    public SubmissionDTO getSubmissionById(@RequestParam Long bookId) {
        return bookService.getSubmissionById(bookId);
    }

    @PostMapping("saveSubmission")
    public void saveSubmission(@RequestBody SubmissionDTO submissionDTO) {
        bookService.saveSubmission(submissionDTO);
    }

    @PutMapping("updateSubmission")
    public void updateSubmission(@RequestParam Long submissionID, @RequestBody SubmissionDTO submissionDTO) {
        bookService.updateSubmission(submissionID,submissionDTO);
    }

    @PutMapping("gradeSubmission")
    public void gradeSubmission(@RequestParam Long submissionID, Long newGrade) {
        bookService.gradeSubmission(submissionID, newGrade);
    }

    @DeleteMapping("deleteSubmissionById")
    public void deleteSubmissionById(Long submissionID) {
        bookService.deleteSubmissionById(submissionID);
    }

    @GetMapping("getSubmissionByAssigmentId")
    public List<SubmissionDTO> getSubmissionByAssigmentId(@RequestParam Long bookId) {
        return bookService.getSubmissionByAssigmentID(bookId);
    }
}
