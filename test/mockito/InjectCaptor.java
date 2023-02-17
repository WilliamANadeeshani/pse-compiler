package mockito;

import de.tum.in.ase.pse.B;
import de.tum.in.ase.pse.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InjectCaptor {
    @Mock
    B b;

    @InjectMocks
    C c;

    @Test
    public void injector() {
        c.getInt();
    }

    @Captor
    ArgumentCaptor<List<String>> captor;


    @Test
    public void argumentCaptor() {
        List<String> argument = Arrays.asList("H", "W");
        c.printList(argument);

        verify(b).voidString(any());
        verify(b).getList(captor.capture());
        assertEquals(argument, captor.getValue());

    }



}
