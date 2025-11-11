package com.schoolProject.domain.student;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(CPF cpf) {
        super("Student not founded with CPF:" + cpf.getCpf());
    }
}
