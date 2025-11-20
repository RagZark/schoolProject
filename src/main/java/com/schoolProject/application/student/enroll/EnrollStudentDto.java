package com.schoolProject.application.student.enroll;

import com.schoolProject.domain.student.CPF;
import com.schoolProject.domain.student.Email;
import com.schoolProject.domain.student.Student;

public class EnrollStudentDto {
    private String studentName;
    private String studentCpf;
    private String studentEmail;

    public EnrollStudentDto(String studentName, String studentCpf, String studentEmail) {
        this.studentName = studentName;
        this.studentCpf = studentCpf;
        this.studentEmail = studentEmail;
    }

    public Student createStudent() {
        return new Student(
                new CPF(studentCpf),
                studentName,
                new Email(studentEmail));
    }
}
