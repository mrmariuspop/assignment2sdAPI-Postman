package com.spring.presentation.service.impl;

import com.spring.presentation.dao.AttendenceDAO;
import com.spring.presentation.dao.BookDAO;
import com.spring.presentation.model.Attendance;
import com.spring.presentation.model.Book;
import com.spring.presentation.service.AttendenceDTO;
import com.spring.presentation.service.AttendenceService;
import com.spring.presentation.service.BookDTO;
import com.spring.presentation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Service
public class AttendenceServiceImpl implements AttendenceService {

    private final AttendenceDAO attendenceDAO;

    @Autowired
    public AttendenceServiceImpl(AttendenceDAO attendenceDAO) {
        this.attendenceDAO = attendenceDAO;
    }

    public List<Attendance> getAllAttendences() {
        return attendenceDAO.findAll();
    }

    public Attendance getAttendenceById(Long attendenceId) {
        return attendenceDAO.findOne(attendenceId);
    }

    public Attendance saveAttendence(AttendenceDTO attendanceDTO) {
        Attendance attendanceToBeSaved = new Attendance(attendanceDTO.getLaboratoryId());

        if (attendenceDAO.findByLaboratoryId(attendanceToBeSaved.getLaboratoryId()) == null) {

            attendenceDAO.save(attendanceToBeSaved);
            return attendenceDAO.findByLaboratoryId(attendanceDTO.getLaboratoryId());

        } else {
            return null;
        }
    }

    public Attendance updateAttendence(Long attendenceId, AttendenceDTO attendanceDTO) {
        Attendance attendanceToBeUpdated = attendenceDAO.findOne(attendenceId);

        if (attendanceToBeUpdated != null) {
            attendanceToBeUpdated.setLaboratoryId(attendanceDTO.getLaboratoryId());
            attendenceDAO.save(attendanceToBeUpdated);
            return attendanceToBeUpdated;
        } else {
            return null;
        }
    }

    public void deleteAttendenceById(Long attendenceId) {
        attendenceDAO.delete(attendenceId);
    }
}
