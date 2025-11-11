package com.schoolProject.domain.student;

public interface PasswordHasher {

    String passwordHasher(String password);

    boolean passwordHasherValidate(String passwordHasher, String password);

}
