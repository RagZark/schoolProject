package com.schoolProject.domain.student;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private final CPF cpf;
    private final String name;
    private final Email email;
    private final List<Phone> phoneNumbers = new ArrayList<>();

    public Student(CPF cpf, String name, Email email){
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void addPhoneNumber(String ddd, String number) throws IllegalArgumentException {
        this.phoneNumbers.add(new Phone(ddd, number));
    }

    public List<Phone> getPhoneNumbers(){
        return phoneNumbers;
    }
}
