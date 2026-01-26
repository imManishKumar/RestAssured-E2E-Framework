package APITests;

import Base.AuthService;
import Base.UserManagementService;
import RequestModels.LoginRequest;
import ResponseModels.LoginResponse;
import ResponseModels.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetUserInfoTest {

    @Test( description = "Verify user details")
    public void getUserInfoTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("jatin_007", "Jatin_007"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        UserManagementService userManagementService = new UserManagementService();
        response = userManagementService.getUserProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getId());

    }
}
