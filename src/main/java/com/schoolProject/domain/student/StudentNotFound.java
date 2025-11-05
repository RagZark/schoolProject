package com.schoolProject.domain.student;

public class StudentNotFound extends RuntimeException {
  public StudentNotFound(String message) {
    super(message);
  }
}
