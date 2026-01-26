package APITests;

import Base.AuthService;
import Base.UserManagementService;
import RequestModels.LoginRequest;
import RequestModels.UpdateProfileRequest;
import ResponseModels.LoginResponse;
import ResponseModels.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserInfoTest {
    @Test(description = "Update user info test")
    public void updateUserInfoTest(){
        UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest("sharma", "jatin", "JATIN123@GMAIL.COM", "9909090909");
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("jatin_007", "Jatin_007"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        UserManagementService userManagementService = new UserManagementService();
        response = userManagementService.updateUserProfile(loginResponse.getToken(), updateProfileRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getFirstName(), "sharma");
        Assert.assertEquals(userProfileResponse.getMobileNumber(), "9909090909");
    }
}
