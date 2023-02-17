package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring")
public class AppConfig {

    @Bean
    public InterfaceA A() {
        return new A();
    }

    @Bean
    public B B() {return new B();}


    @Bean
    public int setId() {
        return 123678;
    }

}
