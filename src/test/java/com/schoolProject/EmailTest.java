package com.schoolProject;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class EmailTest {

    @Test
    void emailIsValid(){
        var validatorEmail = new Email();
        assertTrue(validatorEmail.validatorAddress("test@test.com"));
    }

    @Test
    void emailIsInvalid(){
        var validatorEmail = new Email();
        Assertions.assertFalse(validatorEmail.validatorAddress("test.com"));
    }

    @Test
    void dontUseInvalidAddress(){
        var address = new Email();

        assertThrows(IllegalArgumentException.class, () -> address.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> address.setAddress(""));
        assertThrows(IllegalArgumentException.class, () -> address.setAddress("invalidEmail"));
    }
}