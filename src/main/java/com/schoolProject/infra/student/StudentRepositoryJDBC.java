package com.schoolProject.infra.student;

import com.schoolProject.domain.student.CPF;
import com.schoolProject.domain.student.Phone;
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
        String sqlStudent = "INSERT INTO STUDENT (cpf, name, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sqlStudent)){
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();
        }

        String sqlPhone = "INSERT INTO PHONE_NUMBERS (cpf, ddd, number) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sqlPhone)){
            for (Phone phone : student.getPhoneNumbers()){
                ps.setString(1, student.getCpf());
                ps.setString(2, phone.getDdd());
                ps.setString(3, phone.getNumber());
                ps.addBatch();
            }
            ps.executeBatch();
        }
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
