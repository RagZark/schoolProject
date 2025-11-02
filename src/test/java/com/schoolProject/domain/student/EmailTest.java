package com.schoolProject.domain.student;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EmailTest {

    @Test
    void shouldAcceptValidEmail() {
        Email email = new Email("example@example.com");
        assertEquals("example@example.com", email.getAddress());
    }

    @Test
    void shouldRejectEmailWithoutAtSymbol() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Email("exampleexample.com"));
        assertEquals("The provided email address is invalid", exception.getMessage());
    }

    @Test
    void shouldRejectEmailWithoutDomain() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Email("example@"));
        assertEquals("The provided email address is invalid", exception.getMessage());
    }

    @Test
    void shouldRejectNullEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Email(null));
        assertEquals("The provided email address is invalid", exception.getMessage());
    }

    @Test
    void shouldRejectEmailWithSpaces() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Email("example test@example.com"));
        assertEquals("The provided email address is invalid", exception.getMessage());
    }
}