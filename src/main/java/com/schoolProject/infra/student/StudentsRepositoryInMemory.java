package com.schoolProject.infra.student;

import com.schoolProject.domain.student.CPF;
import com.schoolProject.domain.student.Student;
import com.schoolProject.domain.student.StudentNotFound;
import com.schoolProject.domain.student.StudentsRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsRepositoryInMemory implements StudentsRepository {

    private List<Student> enrolleds = new ArrayList<>();

    @Override
    public void enrollStudent(Student student) throws SQLException {
        this.enrolleds.add(student);
    }

    @Override
    public Student searchByCpf(CPF cpf) {
        return this.enrolleds.stream()
                .filter(s -> s.getCpf().equals(cpf.getCpf()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return this.enrolleds;
    }
}
