package Base;

import RequestModels.LoginRequest;
import RequestModels.SignUpRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService  extends BaseService{
    private static final String BASE_PATH = "api/auth";

    public Response login(LoginRequest payload) {
        return postRequest(payload, BASE_PATH + "/login");
    }

    public Response signUp(SignUpRequest payload) {
        return postRequest(payload, BASE_PATH + "/signup");
    }

    public Response forgotPassword(String email) {
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email", email);
        return postRequest(payload, BASE_PATH + "/forgot-password");
    }
}
