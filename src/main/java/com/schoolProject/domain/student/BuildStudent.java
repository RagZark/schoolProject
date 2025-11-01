package com.schoolProject.domain.student;

import java.lang.IllegalArgumentException;

public class BuildStudent {

    private Student student;

    public BuildStudent buildStudentNameCpfEmail(String name, String cpf, String email) throws IllegalArgumentException {
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public BuildStudent buildPhoneNumber(String ddd, String number) throws IllegalArgumentException {
        this.student.addPhoneNumber(ddd, number);
        return this;
    }

    public Student create(){
        return this.student;
    }

}
