package com.schoolProject.application.student.enroll;

import com.schoolProject.domain.student.Student;
import com.schoolProject.domain.student.StudentsRepository;

import java.sql.SQLException;

public class EnrollStudent {

    private final StudentsRepository repository;

    public EnrollStudent(StudentsRepository repository) {
        this.repository = repository;
    }

    // This parameter is for test in this study
    public void enroll(EnrollStudentDto data) throws SQLException {
        Student newStudent = data.createStudent();
        repository.enrollStudent(newStudent);
    }
}
