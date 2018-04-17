package com.spring.presentation.controller;

import com.spring.presentation.model.Student;
import com.spring.presentation.service.StudentDTO;
import com.spring.presentation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("getAllStudents")
    public List<Student> getAllStudents() {
        try {
            return studentService.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getStudentById")
    public Student getStudentById(@RequestParam Long studentId) {
        try {
            return studentService.getStudentById(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("saveStudent")
    public Student saveStudent(@RequestBody StudentDTO studentDTO) {
        try {
            return studentService.saveStudent(studentDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateStudent")
    public Student updateStudent(@RequestParam Long studentId, @RequestBody StudentDTO studentDTO) {
        try {
            return studentService.updateStudent(studentId, studentDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("deleteStudentById")
    public String deleteStudentById(Long studentId) {
        try {
            studentService.deleteStudentById(studentId);
            return "Student with id = " + studentId + " successful deleted!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
