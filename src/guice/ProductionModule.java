package guice;

import com.google.inject.AbstractModule;

public class ProductionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AI.class).to(AIImplementation.class);
        bind(BI.class).to(BI_Implementation.class);
    }
}
