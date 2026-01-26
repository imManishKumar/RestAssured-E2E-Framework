package APITests;

import Base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test(description = "Verify forgot password functionality")
    public void forgotPasswordTest(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("raj0.8370239187499446@gmail.com");
        System.out.println(response.asPrettyString());
    }


}
