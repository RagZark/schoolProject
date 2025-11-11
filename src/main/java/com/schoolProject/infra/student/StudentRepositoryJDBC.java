package com.schoolProject.infra.student;

import com.schoolProject.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJDBC implements StudentsRepository {

    private final Connection connection;

    public StudentRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enrollStudent(Student student) throws SQLException {
        String sqlStudent = "INSERT INTO STUDENT (cpf, name, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sqlStudent)) {
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        String sqlPhone = "INSERT INTO PHONE_NUMBERS (cpf, ddd, number) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sqlPhone)) {
            for (Phone phone : student.getPhoneNumbers()) {
                ps.setString(1, student.getCpf());
                ps.setString(2, phone.getDdd());
                ps.setString(3, phone.getNumber());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Student searchByCpf(CPF cpf) {
        try {
            String sql = "SELECT name, email FROM STUDENT WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpf());

            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();
            if (!found) {
                throw new StudentNotFound(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student founded = new Student(cpf, name, email);

            sql = "SELECT ddd, number FROM PHONE_NUMBER WHERE cpf = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpf());
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                founded.addPhoneNumber(ddd, number);
            }
            return founded;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        try {
            String sql = "SELECT cpf, name, email FROM STUDENT";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Student> students = new ArrayList<>();

            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String name = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Student student = new Student(cpf, name, email);

                sql = "SELECT ddd, number FROM PHONE_NUMBER WHERE cpf = ?";

                PreparedStatement psPhone = connection.prepareStatement(sql);
                psPhone.setString(1, cpf.getCpf());
                ResultSet rsPhone = psPhone.executeQuery();

                while (rsPhone.next()) {
                    String number = rsPhone.getString("number");
                    String ddd = rsPhone.getString("ddd");
                    student.addPhoneNumber(ddd, number);
                }
                students.add(student);
            }
            return students;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
