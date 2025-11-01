package com.schoolProject;

import javax.naming.directory.InvalidAttributeValueException;

public class Phone {
    private String ddd;
    private String number;

    public Phone(String ddd, String number) throws InvalidAttributeValueException {
        this.ddd = validateDdd(ddd);
        this.number = validateNumber(number);
    }


    public String validateDdd(String ddd) throws InvalidAttributeValueException {
        if (ddd.matches(".*[a-zA-Z\\s].*") || ddd.length() != 3){
            throw new InvalidAttributeValueException("Please, set a valid DDD");
        }
        return ddd;
    }

    public String validateNumber(String number) {
        if (number.length() < 8 || number.length() > 9 || number.matches(".*[a-zA-Z\\s].*") ) {
            throw new IllegalArgumentException("Please, set a valid phone number");
        }
        return number;
    }
}
