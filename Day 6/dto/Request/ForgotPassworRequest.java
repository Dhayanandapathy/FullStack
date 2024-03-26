package com.java.agrofund.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForgotPassworRequest {
    private String email;
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
    
}
