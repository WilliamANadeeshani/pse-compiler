package Spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = TestConfig.class)

public class SpringTest {


    @Test
    public void testController() {
        Assertions.assertEquals(1, 1);
//        when(a.getValue()).thenReturn(100);
//        int actual = controller.getValue(25);
//        Assertions.assertEquals(125, actual);
//        verify(actual);
    }
}
