package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.mockito.Mockito.when;

@ExtendWith(EasyMockExtension.class)
public class GuiceTestClass {

    private Controller controller;
    private Injector injector;
    private AI ai;
    private BI bi;

    @BeforeEach
    void beforeAll() {
        injector = Guice.createInjector(new TestModule());
        this.controller = injector.getInstance(Controller.class);
        ai = injector.getInstance(AI.class);
        bi = injector.getInstance(BI.class);
    }

    @Test
    public void testControllerGetInt() {
        when(bi.getSum()).thenReturn(16);
        expect(ai.getInt()).andReturn(134);
        replay(ai);
        Assertions.assertEquals(150, controller.getInt());
        EasyMock.verify(ai);
        Mockito.verify(bi);
    }

}
