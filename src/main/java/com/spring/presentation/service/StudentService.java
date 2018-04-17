package com.spring.presentation.service;

import com.spring.presentation.model.Student;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long studentId);

    Student saveStudent(StudentDTO StudentDTO);

    Student updateStudent(Long studentId, StudentDTO StudentDTO);

    void deleteStudentById(Long studentId);
}
