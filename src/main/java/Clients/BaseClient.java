package Clients;

import Utilities.TestData;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClient {

    private RequestSpecification requestSpecification;
    private ResponseBody responseBody;
    private Integer statusCode;
    private Response response;

    public BaseClient() {
        RestAssured.baseURI = TestData.BASEURL;
    }

    public void initRestAPI() {
        requestSpecification = RestAssured.given();
    }

    /**
     * This method calls the Rest API
     */
    public void sendHttpRequest(Method method, String endpoint) {
        response = requestSpecification.request(method, endpoint);
        setResponseBody(response.getBody());
        setStatusCode(response.getStatusCode());
    }

    public void setBody(Object body) {
        requestSpecification.body(body);
    }

    public void setQueryParam(String key, Object value) {
        requestSpecification.queryParam(key, value);
    }

    public void addHeader(String header, String value) {
        requestSpecification.header(header, value);
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    private void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    private void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
