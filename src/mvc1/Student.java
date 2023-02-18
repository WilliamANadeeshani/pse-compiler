package mvc1;

import java.util.Objects;

public class Student extends Observable{
    private String name;

    private int result;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return student.getName().equals(name);
    }

    public String getName() {
        return name;
    }

    public Student(String name) {
        this.name = name;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
