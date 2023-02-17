package guice;

import com.google.inject.AbstractModule;
import org.easymock.EasyMock;

import static org.mockito.Mockito.mock;

public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AI.class).toInstance(EasyMock.createMock(AI.class));
        bind(BI.class).toInstance(mock(BI.class));
    }

}
