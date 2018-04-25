package com.spring.presentation.service.impl;

import com.spring.presentation.dao.AssigmentDAO;
import com.spring.presentation.dao.StudentDAO;
import com.spring.presentation.dao.SubmissionDAO;
import com.spring.presentation.model.Assigment;
import com.spring.presentation.model.Student;
import com.spring.presentation.model.Submission;
import com.spring.presentation.service.StudentDTO;
import com.spring.presentation.service.SubmissionDTO;
import com.spring.presentation.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionDAO submissionDAO;
    private final StudentDAO studentDAO;
    private final AssigmentDAO assigmentDAO;

    @Autowired
    public SubmissionServiceImpl(SubmissionDAO bookDAO, StudentDAO studentDAO , AssigmentDAO assigmentDAO) {
        this.submissionDAO = bookDAO;
        this.studentDAO=studentDAO;
        this.assigmentDAO=assigmentDAO;
    }

    public List<SubmissionDTO> getAllSubmissions() {

        List<Submission> subm =  submissionDAO.findAll();
        List<SubmissionDTO> dtos = new ArrayList<>();
        for(Submission s : subm)
        {
            dtos.add(new SubmissionDTO(s.getStudent().getStudentUid(),s.getAssignment().getassigmentUid(),s.getDate(),s.getGrade()));

        }
        return dtos;
    }

    public SubmissionDTO getSubmissionById(Long bookId) {
        Submission s = submissionDAO.findOne(bookId);
        return new SubmissionDTO(s.getStudent().getStudentUid(),s.getAssignment().getassigmentUid(),s.getDate(),s.getGrade());
    }

    public void  saveSubmission(SubmissionDTO submissionDTO) {
        Student s = studentDAO.findOne(submissionDTO.getStudent());
        Assigment a = assigmentDAO.findOne(submissionDTO.getAssignment());

        Submission bookToBeSaved = new Submission(s, a, submissionDTO.getDate(), submissionDTO.getGrade());
        submissionDAO.save(bookToBeSaved);

    }

    public void gradeSubmission(Long submissionId, Long newGrade)
    {
        Submission s1 = submissionDAO.findOne(submissionId);
        s1.setGrade(newGrade);
        submissionDAO.save(s1);
    }

    public void updateSubmission(Long bookId, SubmissionDTO submissionDTO) {
        Submission submissionToBeUpdated = submissionDAO.findOne(bookId);
        Student s = studentDAO.findOne(submissionDTO.getStudent());
        Assigment a = assigmentDAO.findOne(submissionDTO.getAssignment());

        if (submissionToBeUpdated != null) {
            submissionToBeUpdated.setStudent(s);
            submissionToBeUpdated.setAssignment(a);
            submissionToBeUpdated.setDate(submissionDTO.getDate());
            submissionToBeUpdated.setGrade(submissionDTO.getGrade());
            submissionDAO.save(submissionToBeUpdated);
        }
    }

    public void deleteSubmissionById(Long bookId) {
        submissionDAO.delete(bookId);
    }

    @Override
    public List<SubmissionDTO> getSubmissionByAssigmentID(Long assigmentID) {

        List<Submission> subm = submissionDAO.getSubmissionsByAssigment_assigmentUid(assigmentID);
        List<SubmissionDTO> dtos = new ArrayList<>();
        for(Submission s : subm)
            dtos.add(new SubmissionDTO(s.getStudent().getStudentId(),s.getAssignment().getassigmentUid(),s.getDate(),s.getGrade()));
        return dtos;

    }
}
