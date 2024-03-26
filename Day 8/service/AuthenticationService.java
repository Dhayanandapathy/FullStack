package com.java.agrofund.service;

import com.java.agrofund.dto.Request.ForgotPassworRequest;
import com.java.agrofund.dto.Request.LoginRequest;
import com.java.agrofund.dto.Request.RegisterRequest;
import com.java.agrofund.dto.Response.BasicsResponse;
import com.java.agrofund.dto.Response.LoginResponse;

public interface AuthenticationService {
    BasicsResponse<String> register(RegisterRequest registerRequest);

    BasicsResponse<String> forgotPassword(ForgotPassworRequest forgotPasswordRequest);

    BasicsResponse<LoginResponse> login(LoginRequest loginRequest);
    
}
