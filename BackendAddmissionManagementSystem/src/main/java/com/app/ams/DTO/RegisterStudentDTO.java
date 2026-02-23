package com.app.ams.DTO;

import lombok.Data;

@Data
public class RegisterStudentDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
}