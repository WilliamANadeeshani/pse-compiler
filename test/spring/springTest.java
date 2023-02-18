package spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class springTest {

    private ApplicationContext context;
    private Controller controller;

    private InterfaceA a;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(TestConfig.class);
        controller = context.getBean(Controller.class);
        a = context.getBean(InterfaceA.class);
    }

    @Test
    public void testDI() {
        when(a.getValue()).thenReturn(12);
        int actual = controller.getValue(100);
        assertEquals(112, actual);
        verify(a).getValue();
    }
}
