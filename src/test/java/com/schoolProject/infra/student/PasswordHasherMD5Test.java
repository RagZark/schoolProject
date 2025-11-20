package com.schoolProject.infra.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordHasherMD5Test {

    @Test
    void shouldReturnTrue() {
        PasswordHasherMD5 passwordHasherMD5 = new PasswordHasherMD5();
        String password = passwordHasherMD5.passwordHasher("rafael");

        assertTrue(passwordHasherMD5.passwordHasherValidate(password, "rafael"));
    }
}