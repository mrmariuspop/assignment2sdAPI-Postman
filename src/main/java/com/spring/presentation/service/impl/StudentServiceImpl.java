package com.spring.presentation.service.impl;

import com.spring.presentation.dao.StudentDAO;
import com.spring.presentation.model.Admin;
import com.spring.presentation.model.Student;
import com.spring.presentation.service.StudentDTO;
import com.spring.presentation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentDAO.findOne(studentId);
    }

    public Student getStudentByEmailAndToken(String email, String token) {
        return studentDAO.findByEmailAndToken(email,token);
    }

    public Student saveStudent(StudentDTO studentDTO) {
        Student studentToBeSaved = new Student(studentDTO.getEmail(),studentDTO.getPassword(), studentDTO.getFullname(), studentDTO.getGrupa(), studentDTO.getHobby(), studentDTO.getToken());

        if (studentDAO.findByEmailAndFullname(studentToBeSaved.getEmail(), studentToBeSaved.getFullname() ) == null) {

            studentDAO.save(studentToBeSaved);
            return studentDAO.findByEmailAndFullname(studentDTO.getEmail(), studentDTO.getFullname());

        } else {
            return null;
        }
    }

    public Student updateStudent(Long studentId, StudentDTO studentDTO) {
        Student studentToBeUpdated = studentDAO.findOne(studentId);

        if (studentToBeUpdated != null) {

            studentToBeUpdated.setPassword((studentDTO.getPassword()));
            studentToBeUpdated.setFullname(studentDTO.getFullname());
            studentToBeUpdated.setGrupa(studentDTO.getGrupa());
            studentToBeUpdated.setHobby(studentDTO.getHobby());


            studentDAO.save(studentToBeUpdated);
            return studentToBeUpdated;
        } else {
            return null;
        }
    }

    public void deleteStudentById(Long studentId) {
        studentDAO.delete(studentId);
    }
}
