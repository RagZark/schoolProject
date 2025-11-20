import com.schoolProject.domain.student.*;
import com.schoolProject.infra.student.StudentsRepositoryInMemory;

import java.sql.SQLException;

public class EnrollStudentMain {
    public static void main(String[] args) throws SQLException {
        String name = "Michael Scott";
        CPF cpf = new CPF("529.982.247-25");
        Email email = new Email("michaelScott@scott.com");

        Student student = new Student(cpf, name, email);
        student.addPhoneNumber("53", "99999999");

        StudentsRepository repository = new StudentsRepositoryInMemory();

        repository.enrollStudent(student);
    }
}
