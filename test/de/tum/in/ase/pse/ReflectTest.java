package de.tum.in.ase.pse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class ReflectTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Reflect reflect = new Reflect(1234); // create object
        Class<? extends Reflect> c = reflect.getClass(); // get class representation
        Field field = c.getDeclaredField("id"); // capture field
        field.trySetAccessible(); //turn field accessibility
        Assertions.assertEquals(1234, field.get(reflect));
    }
}
