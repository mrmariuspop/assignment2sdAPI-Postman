package com.spring.presentation.service;

import com.spring.presentation.model.Attendance;

import java.util.List;

/**
 * @author Nicoleta GHITESCU at 27-Mar-18
 */

public interface AttendenceService {

    List<Attendance> getAllAttendences();

    Attendance getAttendenceById(Long attendenceId);

    Attendance saveAttendence(AttendenceDTO attendenceDTO);

    Attendance updateAttendence(Long attendenceId, AttendenceDTO attendenceDTO);

    void deleteAttendenceById(Long attendenceId);
}
