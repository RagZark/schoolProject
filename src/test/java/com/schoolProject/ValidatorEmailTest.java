package com.schoolProject;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ValidatorEmailTest {

    @Test
    void emailIsValid(){
        var validatorEmail = new ValidatorEmail();
        assertTrue(validatorEmail.validatorEmail("test@test.com"));
    }

    @Test
    void emailIsInvalid(){
        var validatorEmail = new ValidatorEmail();
        Assertions.assertFalse(validatorEmail.validatorEmail("test.com"));
    }
}