package com.sshare.backend.security.payload;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    private String accessToken;
    private String tokenType = "Bearer";
}
