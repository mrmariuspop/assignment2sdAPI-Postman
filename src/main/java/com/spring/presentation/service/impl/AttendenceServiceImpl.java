package com.spring.presentation.service.impl;

import com.spring.presentation.dao.AttendenceDAO;
import com.spring.presentation.dao.StudentDAO;
import com.spring.presentation.model.Attendance;
import com.spring.presentation.model.Student;
import com.spring.presentation.service.AttendenceDTO;
import com.spring.presentation.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

@Service
public class AttendenceServiceImpl implements AttendenceService {

    private final AttendenceDAO attendenceDAO;
    private final StudentDAO studentDAO;

    @Autowired
    public AttendenceServiceImpl(AttendenceDAO attendenceDAO ,StudentDAO studentDAO) {
        this.attendenceDAO = attendenceDAO;
        this.studentDAO=studentDAO;
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

    @Override
    public void addPresentStudent(long attendanceID , long studentID) {

        Attendance a = attendenceDAO.getOne(attendanceID);
        Student s = studentDAO.getOne(studentID);

        a.addStudent(s);
        attendenceDAO.save(a);

    }
}
