package com.schoolProject;

import javax.management.InvalidAttributeValueException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidAttributeValueException, javax.naming.directory.InvalidAttributeValueException {
        Email email = new Email();
        email.setAddress("voltaire@gmail.com");
        System.out.println(email.getAddress());

        var student = new Student();

        CPF cpf = new CPF();
        cpf.setCpf("49991537007");
        System.out.println(cpf.getCpf());

    }
}