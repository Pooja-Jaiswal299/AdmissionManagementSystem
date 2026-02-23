package com.app.ams.DTO;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
