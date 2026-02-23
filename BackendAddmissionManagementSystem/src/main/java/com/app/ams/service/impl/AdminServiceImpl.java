package com.app.ams.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.ams.DTO.BatchDTO;
import com.app.ams.DTO.CourseDTO;
import com.app.ams.DTO.DiscountDTO;
import com.app.ams.exception.CustomException;
import com.app.ams.model.Batch;
import com.app.ams.model.Course;
import com.app.ams.model.Discount;
import com.app.ams.model.Registration;
import com.app.ams.repository.BatchRepository;
import com.app.ams.repository.CourseRepository;
import com.app.ams.repository.DiscountRepository;
import com.app.ams.repository.RegistrationRepository;
import com.app.ams.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CourseRepository courseRepository;
    private final BatchRepository batchRepository;
    private final DiscountRepository discountRepository;
    private final RegistrationRepository registrationRepository;

    public void createCourse(CourseDTO dto){
        Course c = new Course();
        c.setCourseName(dto.getCourseName());
        courseRepository.save(c);
    }

    public void createBatch(BatchDTO dto){
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new CustomException("Course not found"));

        Batch b = new Batch();
        b.setBatchName(dto.getBatchName());
        b.setFee(dto.getFee());
        b.setCapacity(dto.getCapacity());
        b.setMode(dto.getMode());
        b.setCourse(course);

        batchRepository.save(b);
    }

    public void createDiscount(DiscountDTO dto){

        Batch batch = batchRepository.findById(dto.getBatchId())
                .orElseThrow(() -> new CustomException("Batch not found"));

        Discount d = new Discount();
        d.setDiscountName(dto.getDiscountName());
        d.setType(dto.getType());
        d.setValue(dto.getValue());
        d.setStartDate(dto.getStartDate());
        d.setEndDate(dto.getEndDate());
        d.setBatch(batch);

        discountRepository.save(d);
    }

    public List<Registration> getAllRegistrations(){
        return registrationRepository.findAll();
    }
}
