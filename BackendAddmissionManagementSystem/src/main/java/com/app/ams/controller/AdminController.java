package com.app.ams.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ams.DTO.BatchDTO;
import com.app.ams.DTO.CourseDTO;
import com.app.ams.DTO.DiscountDTO;
import com.app.ams.model.Registration;
import com.app.ams.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/course")
    public void createCourse(@RequestBody CourseDTO dto){
        adminService.createCourse(dto);
    }

    @PostMapping("/batch")
    public void createBatch(@RequestBody BatchDTO dto){
        adminService.createBatch(dto);
    }

    @PostMapping("/discount")
    public void createDiscount(@RequestBody DiscountDTO dto){
        adminService.createDiscount(dto);
    }

    @GetMapping("/registrations")
    public List<Registration> all(){
        return adminService.getAllRegistrations();
    }
}
