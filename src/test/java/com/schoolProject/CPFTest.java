package com.schoolProject;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.directory.InvalidAttributeValueException;


class CPFTest {
    @Test
    public void checkTenthDigit(){
        var cpf = new CPF();

        assertTrue(cpf.checkTenthDigit("49991537007"));
    }

    @Test
    public void checkEleventhDigit(){
        var cpf = new CPF();

        assertTrue(cpf.checkEleventhDigit("49991537007"));
    }

    @Test
    public void checkCpfIsValid() throws InvalidAttributeValueException {
        var cpf = new CPF();

        Assertions.assertEquals("49991537007", cpf.cpfIsValid("49991537007"));
    }

}