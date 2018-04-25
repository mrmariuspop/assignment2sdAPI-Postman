package com.spring.presentation.service;


import com.spring.presentation.model.Submission;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public interface SubmissionService {

    List<SubmissionDTO> getAllSubmissions();

    SubmissionDTO getSubmissionById(Long submissionId);

    void saveSubmission(SubmissionDTO submission);

    void updateSubmission(Long submissionId, SubmissionDTO submissionDTO);

    void gradeSubmission(Long submissionId, Long newGrade);

    void deleteSubmissionById(Long submissionId);

    List<SubmissionDTO> getSubmissionByAssigmentID(Long assigmentID);
}
