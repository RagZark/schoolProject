package com.schoolProject;

import javax.naming.directory.InvalidAttributeValueException;

public class Phone {
    private String ddd;
    private String number;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) throws InvalidAttributeValueException {
        if (ddd.matches(".*[a-zA-Z].*") || ddd.length() != 3){
            throw new InvalidAttributeValueException("Please, set a valid DDD");
        } else {
            this.ddd = ddd;
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number.length() < 8 || number.length() > 9 || number.matches(".*[a-zA-Z].*") ) {
            throw new IllegalArgumentException("Please, set a valid phone number");
        } else {
            this.number = number;
        }
    }
}
