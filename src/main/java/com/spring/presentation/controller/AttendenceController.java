package com.spring.presentation.controller;

import com.spring.presentation.model.Attendance;
import com.spring.presentation.model.Book;
import com.spring.presentation.service.AttendenceDTO;
import com.spring.presentation.service.AttendenceService;
import com.spring.presentation.service.BookDTO;
import com.spring.presentation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@RestController
@RequestMapping("attendences")
public class AttendenceController {

    private final AttendenceService attendenceService;

    @Autowired
    public AttendenceController(AttendenceService attendenceService) {
        this.attendenceService = attendenceService;
    }

    @GetMapping("getAllAttendences")
    public List<Attendance> getAllAttendnces() {
        try {
            return attendenceService.getAllAttendences();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getAttendanceById")
    public Attendance getAttendanceById(@RequestParam Long attendenceId) {
        try {
            return attendenceService.getAttendenceById(attendenceId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("saveAttendance")
    public Attendance saveAttendance(@RequestBody AttendenceDTO attendenceDTO) {
        try {
            return attendenceService.saveAttendence(attendenceDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateAttendance")
    public Attendance updateAttendance(@RequestParam Long attendenceId, @RequestBody AttendenceDTO attendenceDTO) {
        try {
            return attendenceService.updateAttendence(attendenceId, attendenceDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("deleteAttendanceById")
    public String deleteAttendanceById(Long attendenceId) {
        try {
            attendenceService.deleteAttendenceById(attendenceId);
            return "Attendance with id = " + attendenceId + " successful deleted!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PutMapping("updatePresence")
    public void updateStudent(@RequestParam Long studentId,Long attendanceId) {
        attendenceService.addPresentStudent(attendanceId,studentId);
    }
}
