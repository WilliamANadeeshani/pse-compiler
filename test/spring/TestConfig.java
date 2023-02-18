package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


import static org.mockito.Mockito.mock;
@ComponentScan("spring")
public class TestConfig {
    @Bean
    public InterfaceA A() {
        return mock(InterfaceA.class);
    }

    @Bean B B() {
        return mock(B.class);
    }
}
