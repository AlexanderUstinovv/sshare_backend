package com.sshare.backend.security.payload;

import lombok.Data;

@Data
public class ApiResponse {

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    private Boolean success;
    private String message;
}
