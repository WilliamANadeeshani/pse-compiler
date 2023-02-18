package restClient.client;

import kong.unirest.Callback;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONObject;
import restClient.model.Car;


public class GetCallback implements Callback<JsonNode> {

    private final RESTClientDelegate delegate;

    public GetCallback(RESTClientDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        int statusCode = response.getStatus();
        JsonNode responseJson = response.getBody();
        JSONObject object = responseJson.getObject();
        delegate.getCarFinished(new Car(object), statusCode);
    }

    @Override
    public void failed(UnirestException e) {
        Callback.super.failed(e);
    }

    @Override
    public void cancelled() {
        Callback.super.cancelled();
    }

    private int getResponseStatus(HttpResponse<JsonNode> response) {
        return response.getStatus();
    }
}
