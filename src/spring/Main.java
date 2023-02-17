package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Controller controller = context.getBean(Controller.class);
        System.out.println(controller.getValue(25));
        System.out.println(controller.getId());
        controller.invokeB();
    }
}
