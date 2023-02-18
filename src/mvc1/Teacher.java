package mvc1;

public class Teacher implements Observer{
    private Student student;

    @Override
    public void update() {
        System.out.println("her marks updated!");
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
