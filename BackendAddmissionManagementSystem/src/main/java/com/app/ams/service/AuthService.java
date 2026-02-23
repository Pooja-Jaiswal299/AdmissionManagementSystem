package com.app.ams.service;

import com.app.ams.DTO.AuthRequest;
import com.app.ams.DTO.AuthResponse;
import com.app.ams.DTO.RegisterStudentDTO;

public interface AuthService {
    void registerStudent(RegisterStudentDTO dto);
    AuthResponse login(AuthRequest request);
}
