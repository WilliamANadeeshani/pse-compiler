package restClient.client;

import restClient.model.Car;

public interface RESTClientDelegate {
    void getCarFinished(Car car, int statusCode);

}
