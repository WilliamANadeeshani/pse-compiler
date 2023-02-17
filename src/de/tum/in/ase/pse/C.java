package de.tum.in.ase.pse;

import java.util.LinkedList;
import java.util.List;

public class C {
    private final B b;

    C(B b) {
        this.b = b;
    }

    public void getInt() {
        b.voidString("hello");
    }

    public String printList(List<String> ss) {
        b.voidString("ANY");
        return b.getList(ss).toString();
    }
}
