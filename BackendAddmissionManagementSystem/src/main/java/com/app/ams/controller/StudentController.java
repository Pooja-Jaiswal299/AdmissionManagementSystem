package com.app.ams.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ams.model.Batch;
import com.app.ams.model.Registration;
import com.app.ams.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/batches")
    public List<Batch> batches(){
        return studentService.getAllBatches();
    }

    @PostMapping("/register/{batchId}")
    public Registration register(@PathVariable Long batchId,
                                 @RequestParam(required=false) Long discountId,
                                 Principal principal){
        return studentService.registerBatch(batchId, discountId, principal.getName());
    }

    @GetMapping("/registrations")
    public List<Registration> my(Principal principal){
        return studentService.myRegistrations(principal.getName());
    }
}
