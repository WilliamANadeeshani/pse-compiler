package mvc1;

public class Controller {
    private Teacher teacher;

    public void saveResult(Student student) {
        teacher.setStudent(student);
        student.addObserver(teacher);
    }
}
