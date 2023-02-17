package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ProductionModule());
        Controller controller = injector.getInstance(Controller.class);
        System.out.println(controller.getInt());
    }
}
