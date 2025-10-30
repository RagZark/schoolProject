package com.schoolProject;

import org.apache.commons.validator.routines.EmailValidator;


public class Email {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (!validatorAddress(address) || address == null) {
            throw new IllegalArgumentException("This e-mail is invalid");
        } else {
            this.address = address;
        }
    }

    public boolean validatorAddress(String address){
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(address);
    }
}
