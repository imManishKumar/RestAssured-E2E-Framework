package Base;

import Filter.LoggingFilter;
import RequestModels.LoginRequest;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    private static final String BASE_URL = "http://64.227.160.186:8080/";
    private RequestSpecification requestSpec;

    public BaseService(){
        requestSpec = RestAssured.given().baseUri(BASE_URL);
    }
    protected Response postRequest(Object payload, String endpoint){
        return requestSpec.contentType(ContentType.JSON).body(payload).post(endpoint);
    }
    protected Response getRequest(String endpoint){
        return requestSpec.get(endpoint);
    }
    protected void setAuthToken(String token){
        requestSpec.header("Authorization", "Bearer "+token);
    }
    protected Response putRequest(Object payload, String endpoint){
        return requestSpec.contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    static{
        RestAssured.filters(new LoggingFilter());
    }
}
