package APITests;

import Base.AuthService;
import RequestModels.SignUpRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "Verify account creation")
    public void accountCreationTest() {
        // Test implementation goes here
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .username("raj1234"+String.valueOf(Math.random()))
                .password("raj1234")
                .email("raj"+String.valueOf(Math.random())+"@gmail.com")
                .firstName("raj")
                .lastName("shamani")
                .mobileNumber("2334545678")
                .build();
        AuthService authService = new AuthService();
        Response res = authService.signUp(signUpRequest);
        System.out.println(res.asPrettyString());
        System.out.println(signUpRequest.getEmail());

    }
}
