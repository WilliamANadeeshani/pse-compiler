package restClient.client;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.slf4j.LoggerFactory;
import restClient.model.Car;



public class Application implements RESTClientDelegate {

    private Client client;
    private Car car;

    /**
     * starts the application and invokes a series of REST requests
     */
    public static void main(String[] args) {
        Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);

        Application app = new Application();
        app.invokeRESTRequest();
    }

    /**
     * binds the REST-requests to the concrete client
     */
    public Application() {
        client = new Client();
        client.setDelegate(this);
        Unirest.shutDown();
    }

    /**
     * a series of REST requests - GET requests, POST request, PUT request, DELETE request
     */
    public void invokeRESTRequest() {
        try {

            client.getCarByID("10");

//            Car changedCar = new Car("10", "red", "Mercedes", 125);
//            client.updateCar(changedCar);
//
//            Car newCar = new Car("5", "yellow", "Toyota", 30);
//            client.createNewCar(newCar);
//
//            car = new Car("7", "blue", "Opel", 50);
//            client.createNewCar(car);
//            if (car.getId().equals("7")) {
//                Thread.sleep(100);
//            }
//            client.deleteCar(car);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getCarFinished(Car car, int statusCode) {
        System.out.println("Found " + car.getBrand() + " car");
    }

}
