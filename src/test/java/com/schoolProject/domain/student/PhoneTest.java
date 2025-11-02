package com.schoolProject.domain.student;

import org.junit.jupiter.api.Test;

import java.lang.IllegalArgumentException;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    @Test
    void shouldCreatePhoneWithEightDigitNumber() {
        Phone phone = new Phone("53", "44449999");

        assertEquals("(53)", phone.getDdd());
        assertEquals("4444-9999", phone.getNumber());
    }

    @Test
    void shouldCreatePhoneWithNineDigitNumber() {
        Phone phone = new Phone("11", "988887777");

        assertEquals("(11)", phone.getDdd());
        assertEquals("98888-7777", phone.getNumber());
    }

    @Test
    void shouldRejectDddWithLetters() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("A1", "988887777"));
    }

    @Test
    void shouldRejectDddWithMoreThanTwoDigits() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("123", "988887777"));
    }

    @Test
    void shouldRejectNullDdd() {
        assertThrows(IllegalArgumentException.class, () -> new Phone(null, "988887777"));
    }

    @Test
    void shouldRejectNumberWithLetters() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("53", "9A888777"));
    }

    @Test
    void shouldRejectNumberWithSpaces() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("53", "9888 7777"));
    }

    @Test
    void shouldRejectNullNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("53", null));
    }
}