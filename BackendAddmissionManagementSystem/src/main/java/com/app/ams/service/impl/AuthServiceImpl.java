package com.app.ams.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.ams.DTO.AuthRequest;
import com.app.ams.DTO.AuthResponse;
import com.app.ams.DTO.RegisterStudentDTO;
import com.app.ams.exception.CustomException;
import com.app.ams.model.Role;
import com.app.ams.model.User;
import com.app.ams.repository.UserRepository;
import com.app.ams.security.JwtUtil;
import com.app.ams.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void registerStudent(RegisterStudentDTO dto){

        if(userRepository.findByEmail(dto.getEmail()).isPresent())
            throw new CustomException("Email already exists");

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPhone(dto.getPhone());
        user.setRole(Role.ROLE_STUDENT);

        userRepository.save(user);
    }

    public AuthResponse login(AuthRequest request){

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException("User not found"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new CustomException("Invalid credentials");

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token);
    }
}
