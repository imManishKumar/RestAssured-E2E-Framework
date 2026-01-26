package Base;

import RequestModels.UpdateProfileRequest;
import io.restassured.response.Response;

public class UserManagementService extends BaseService{
    private final static String BASE_PATH = "/api/users/";

    public Response getUserProfile(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH + "profile");
    }
    public Response updateUserProfile(String token, UpdateProfileRequest payload){
        setAuthToken(token);
        return putRequest(payload, BASE_PATH + "profile");
    }

}
