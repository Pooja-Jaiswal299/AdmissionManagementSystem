package com.app.ams.service;

import java.util.List;

import com.app.ams.DTO.BatchDTO;
import com.app.ams.DTO.CourseDTO;
import com.app.ams.DTO.DiscountDTO;
import com.app.ams.model.Registration;

public interface AdminService {
    void createCourse(CourseDTO dto);
    void createBatch(BatchDTO dto);
    void createDiscount(DiscountDTO dto);
    List<Registration> getAllRegistrations();
}
