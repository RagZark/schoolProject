package com.schoolProject.domain.student;

import java.sql.SQLException;
import java.util.List;

public interface StudentsRepository {

    void enrollStudent(Student student) throws SQLException;

    Student searchByCpf(CPF cpf);

    List<Student> listAllEnrolledStudents();

}
