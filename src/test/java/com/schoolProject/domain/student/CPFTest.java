package com.schoolProject.domain.student;


import org.junit.jupiter.api.Test;

import java.lang.IllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;


class CPFTest {
    @Test
    void shouldAcceptValidCpf() throws IllegalArgumentException {
        CPF cpf = new CPF("529.982.247-25");
        assertEquals("529.982.247-25", cpf.getCpf());
    }

    @Test
    void shouldAcceptValidCpfWithoutPunctuation() throws IllegalArgumentException {
        CPF cpf = new CPF("52998224725");
        assertEquals("529.982.247-25", cpf.getCpf());
    }

    @Test
    void shouldRejectCpfWithLessThan11Digits() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890"));
    }

    @Test
    void shouldRejectCpfWithMoreThan11Digits() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("123456789012"));
    }

    @Test
    void shouldRejectCpfWithLetters() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("529a82247b5"));
    }

    @Test
    void shouldRejectCpfWithSpaces() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("529 982 247 25"));
    }

    @Test
    void shouldRejectCpfWithSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("529@982#247$25"));
    }

    @Test
    void shouldRejectCpfWithRepeatedDigits() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("11111111111"));
    }

    @Test
    void shouldRejectCpfWithInvalidVerificationDigits() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("52998224724"));
    }

    @Test
    void shouldRejectNullCpf() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
    }
}