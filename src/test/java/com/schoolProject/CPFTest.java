package com.schoolProject;


import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributeValueException;
import static org.junit.jupiter.api.Assertions.*;


class CPFTest {
    @Test
    public void checkTenthDigitTrue(){
        var cpf = new CPF();

        assertTrue(cpf.checkTenthDigit("49991537007"));
    }

    @Test
    public void checkTenthDigitFalse(){
        var cpf = new CPF();

        assertFalse(cpf.checkTenthDigit("49991537037"));
    }

    @Test
    public void checkEleventhDigitTrue(){
        var cpf = new CPF();

        assertTrue(cpf.checkEleventhDigit("49991537007"));
    }

    @Test
    public void checkEleventhDigitFalse(){
        var cpf = new CPF();

        assertFalse(cpf.checkEleventhDigit("49991537001"));
    }

    @Test
    public void checkCpfIsValid() throws InvalidAttributeValueException {
        var cpf = new CPF();

        assertEquals("49991537007", cpf.cpfIsValid("49991537007"));
    }

    @Test
    public void checkCpfIsInvalid() throws InvalidAttributeValueException {
        var cpf = new CPF();

        assertNotEquals("49991537027", cpf.cpfIsValid("49991537007"));
    }


}