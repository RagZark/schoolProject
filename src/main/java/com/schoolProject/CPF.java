package com.schoolProject;

import javax.naming.directory.InvalidAttributeValueException;

public class CPF {
    private String cpf;

    public String getCpf() {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public void setCpf(String cpf) throws InvalidAttributeValueException {
        this.cpf = cpfIsValid(cpf);
    }

    public String cpfIsValid(String cpf) throws InvalidAttributeValueException {
        if (cpf.matches(".*[a-zA-Z] + .*")){
            throw new InvalidAttributeValueException("Please type your 11 number CPF");
        }
        String cpf11digits = cpf.replaceAll("[^0-9]", "");
        if (checkTenthDigit(cpf) && checkEleventhDigit(cpf)){
            return cpf11digits;
        } else {
            throw new InvalidAttributeValueException("Invalid CPF");
        }

    }

    public boolean checkTenthDigit(String cpf) {
        int totalSum = 0;
        int multiple = 10;

        for (int i = 0; i < cpf.length() - 2; i++) {
            int digitValue = cpf.charAt(i) - '0';
            totalSum += digitValue * multiple;
            multiple--;
        }

        int remainder = totalSum % 11;
        int calcTenthDigit;

        if (remainder < 2) {
            calcTenthDigit = 0;
        } else {
            calcTenthDigit = 11 - remainder;
        }

        int actualTenthDigit = cpf.charAt(9) - '0';


        if (calcTenthDigit == actualTenthDigit) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkEleventhDigit(String cpf) {
        int totalSum = 0;
        int multiple = 11;

        for (int i = 0; i < cpf.length() - 1; i++) {
            int digitValue = cpf.charAt(i) - '0';
            totalSum += digitValue * multiple;
            multiple--;
        }

        int remainder = totalSum % 11;
        int calcEleventhDigit;

        if (remainder < 2) {
            calcEleventhDigit = 0;
        } else {
            calcEleventhDigit = 11 - remainder;
        }

        int actualEleventhDigit = cpf.charAt(10) - '0';


        if (calcEleventhDigit == actualEleventhDigit) {
            return true;
        } else {
            return false;
        }
    }
}