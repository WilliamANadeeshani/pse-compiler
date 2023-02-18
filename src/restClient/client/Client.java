package restClient.client;

import kong.unirest.Unirest;

public class Client {
    private RESTClientDelegate delegate;

    public RESTClientDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(RESTClientDelegate delegate) {
        this.delegate = delegate;
    }

    private static final String BASE_URL = "http://localhost:8080/";

    public void getCarByID(String carId) {
        Unirest.get(BASE_URL + "cars/" + carId).asJsonAsync(new GetCallback(delegate));
    }

    public void updateCar() {

    }
}
