package com.schoolProject.infra.student;

import com.schoolProject.domain.student.CPF;
import com.schoolProject.domain.student.Student;
import com.schoolProject.domain.student.StudentsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryJDBC implements StudentsRepository {

    private final Connection connection;

    public StudentRepositoryJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void enrollStudent(Student student) throws SQLException {
        String sql = "INSERT INTO STUDENT VALUES (NAME, CPF, EMAIL)";
        PreparedStatement ps = connection.prepareStatement(sql);
    }

    @Override
    public Student searchByCpf(CPF cpf) {
        return null;
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return List.of();
    }
}
