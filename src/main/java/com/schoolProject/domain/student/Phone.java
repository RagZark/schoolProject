package com.schoolProject.domain.student;

import java.lang.IllegalArgumentException;

public class Phone {
    private final String ddd;
    private final String number;

    public Phone(String ddd, String number) throws IllegalArgumentException {
        this.ddd = "(" + validateDdd(ddd) + ")";
        this.number = formatedNumber(validateNumber(number));
    }

    public String getDdd(){
        return this.ddd;
    }

    public String getNumber(){
        return this.number;
    }


    private String validateDdd(String ddd) throws IllegalArgumentException {
        if (ddd == null || !ddd.matches("\\d{2}")){
            throw new IllegalArgumentException("Please, set a valid DDD");
        }
        return ddd;
    }

    private String validateNumber(String number) throws IllegalArgumentException {
        if (number == null || !number.matches("\\d{8,9}")) {
            throw new IllegalArgumentException("Please, set a valid phone number");
        }
        return number;
    }

    private String formatedNumber(String number){
        if (number.length() == 8){
            return number.replaceFirst("(\\d{4})(\\d{4})", "$1-$2");
        } else {
            return number.replaceFirst("(\\d{5})(\\d{4})", "$1-$2");
        }
    }



    @Override
    public String toString(){
        return "Number: " + getDdd() + getNumber();
    }
}
