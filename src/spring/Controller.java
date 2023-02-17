package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    private final InterfaceA a;

    @Autowired
    private B b;
    private int id;

    @Autowired
    public Controller(InterfaceA a) {
        this.a = a;
    }

    public int getValue(int value) {
        return this.a.getValue() + value;
    }

    @Autowired
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void invokeB() {
        b.print();
    }
}
