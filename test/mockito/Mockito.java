package mockito;

import de.tum.in.ase.pse.A;
import de.tum.in.ase.pse.B;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.easymock.EasyMock.mock;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class Mockito {

    private A a = new A();
    private B b;
    @Mock
    private B orderB;

    @Test
    public void testA() {
        b = mock(B.class);

        when(b.getValue()).thenReturn(12);
        when(b.print()).thenReturn(1);
        a.interactB(b);

        verify(b).print();
        verify(b).getValue();
    }

    @Spy
    List<String> spyList = new LinkedList<>();

    @Test
    void spyCheck() {
        List<String> list = new LinkedList<>();
        List<String> spiedList = spy(list);
        spiedList.add("one");
        verify(spiedList).add("one");
        spyList.add("Hello");
        verify(spiedList).add(ArgumentMatchers.eq("one"));
    }

    @Test
    public void orderChecker() {
        a.orderChecker(orderB, "Hello");
        a.orderChecker(orderB, "World");
        inOrder(orderB).verify(orderB, times(1)).voidString("Hello");
    }
}
