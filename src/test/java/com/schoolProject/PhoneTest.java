package com.schoolProject;

import org.junit.jupiter.api.Test;

import javax.naming.directory.InvalidAttributeValueException;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    @Test
    void phoneNumberIsValid() throws InvalidAttributeValueException {
        var phoneNumber = new Phone("053", "44449999");

        assertEquals("053", phoneNumber.validateDdd("053"));
        assertEquals("44449999", phoneNumber.validateNumber("44449999"));
    }
}