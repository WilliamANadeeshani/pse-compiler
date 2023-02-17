package de.tum.in.ase.pse;

public class A {
    public int interactB(B b) {
        b.voidMethod();
        b.print();
        b.voidString("Hello");
        b.voidString("World");
        return b.getValue();
    }

    public void orderChecker(B b, String s) {
        b.voidString(s);
    }

}
