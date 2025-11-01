package com.schoolProject.domain.student;

import org.apache.commons.validator.routines.EmailValidator;


public class Email {
    private final String address;

    public Email(String address){
        if (address == null || !validateAddress(address)){
            throw new IllegalArgumentException("The provided email address is invalid");
        }
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    private static boolean validateAddress(String address){
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(address);
    }

    @Override
    public String toString(){
        return address;
    }
}
