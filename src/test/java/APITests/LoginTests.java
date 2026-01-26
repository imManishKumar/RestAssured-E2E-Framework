package APITests;

import Base.AuthService;
import Listener.TestListener;
import RequestModels.LoginRequest;
import RequestModels.SignUpRequest;
import ResponseModels.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

@Listeners(Listener.TestListener.class)
public class LoginTests {

    @Test(description = "verify login with valid credentials")
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest("jatin_007", "Jatin_007");
        AuthService authService = new AuthService();
        Response res = authService.login(loginRequest);
        LoginResponse loginResponse = res.as(LoginResponse.class);
        System.out.println(res.asPrettyString());
        System.out.println("Token = "+loginResponse.getToken());
    }
}
