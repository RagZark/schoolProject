package com.schoolProject.domain.student;

import java.lang.IllegalArgumentException;

public class CPF {
    private final String cpf;

    public CPF(String cpf) throws IllegalArgumentException {
        this.cpf = validateCpf(cpf);
    }

    public String getCpf() {
        return this.cpf;
    }

    public String validateCpf(String cpf) throws IllegalArgumentException {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF cannot be null.");
        }
        if (cpf.matches(".*[^\\d.\\-].*")) {
            throw new IllegalArgumentException("CPF contains invalid characters or spaces.");
        }
        String cpf11digits = cpf.replaceAll("[^0-9]", "");

        if (!cpf11digits.matches("\\d{11}")){
            throw new IllegalArgumentException("Please type a valid 11 digits CPF number.");
        }

        if (cpf11digits.chars().distinct().count() == 1){
            throw new IllegalArgumentException("Invalid CPF: repeated digits");
        }

        if (checkTenthDigit(cpf11digits) && checkEleventhDigit(cpf11digits)){
            return formattedCpf(cpf11digits);
        } else {
            throw new IllegalArgumentException("Invalid CPF");
        }

    }

    private boolean checkTenthDigit(String cpf) {
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


        return calcTenthDigit == actualTenthDigit;
    }

    private boolean checkEleventhDigit(String cpf) {
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


        return calcEleventhDigit == actualEleventhDigit;
    }

    private String formattedCpf(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}