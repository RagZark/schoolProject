import com.schoolProject.domain.student.BuildStudent;
import com.schoolProject.domain.student.CPF;
import com.schoolProject.domain.student.Email;
import com.schoolProject.domain.student.Student;

public class Main {
    public static void main(String[] args) {
        var buildStudent = new BuildStudent();

        var student2 = buildStudent.buildStudentNameCpfEmail("Lucas Mame", "52998224725", "luquinhas@teste.com")
                .buildPhoneNumber("21", "999444555")
                .buildPhoneNumber("21", "99945665")
                .buildPhoneNumber("21", "99977777")
                .create();

        System.out.println(student2);
    }
}
