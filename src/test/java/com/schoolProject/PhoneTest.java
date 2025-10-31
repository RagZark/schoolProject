package com.schoolProject;

import org.junit.jupiter.api.Test;

import javax.naming.directory.InvalidAttributeValueException;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void dddIsValid() throws InvalidAttributeValueException {
        var ddd = new Phone();
        ddd.setDdd("053");
        assertEquals("053", ddd.getDdd());
    }

    @Test
    void dddIsInvalidAttributeValueException() {
        var ddd = new Phone();
        assertThrows(InvalidAttributeValueException.class, () -> ddd.setDdd("a2s"));
        assertThrows(InvalidAttributeValueException.class, () -> ddd.setDdd("1"));
        assertThrows(InvalidAttributeValueException.class, () -> ddd.setDdd("3456"));
    }

    @Test
    void phoneIsValid() throws InvalidAttributeValueException {
        var phoneNumber = new Phone();
        phoneNumber.setNumber("999888777");
        assertEquals("999888777", phoneNumber.getNumber());
    }

    @Test
    void phoneIsInvalidAttributeValueException() {
        var phoneNumber = new Phone();
        assertThrows(IllegalArgumentException.class, () -> phoneNumber.setNumber("99933387a"));
        assertThrows(IllegalArgumentException.class, () -> phoneNumber.setNumber("99933"));
        assertThrows(IllegalArgumentException.class, () -> phoneNumber.setNumber("9999999999"));
    }
}