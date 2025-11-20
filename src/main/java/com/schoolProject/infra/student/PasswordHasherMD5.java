package com.schoolProject.infra.student;

import com.schoolProject.domain.student.PasswordHasher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasherMD5 implements PasswordHasher {


    @Override
    public String passwordHasher(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff)  + 0x100, 16).substring(1));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Password Hasher Error");
        }
    }

    @Override
    public boolean passwordHasherValidate(String passwordHasher, String password) {
        return passwordHasher.equals(passwordHasher(password));
    }
}
