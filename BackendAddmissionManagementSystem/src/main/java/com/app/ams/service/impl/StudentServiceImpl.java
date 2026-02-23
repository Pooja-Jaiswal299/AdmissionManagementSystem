package com.app.ams.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.app.ams.exception.CustomException;
import com.app.ams.model.Batch;
import com.app.ams.model.Discount;
import com.app.ams.model.FlatDiscount;
import com.app.ams.model.PercentageDiscount;
import com.app.ams.model.Registration;
import com.app.ams.model.User;
import com.app.ams.repository.BatchRepository;
import com.app.ams.repository.DiscountRepository;
import com.app.ams.repository.RegistrationRepository;
import com.app.ams.repository.UserRepository;
import com.app.ams.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final BatchRepository batchRepository;
    private final UserRepository userRepository;
    private final DiscountRepository discountRepository;
    private final RegistrationRepository registrationRepository;
    private final FlatDiscount flatDiscount;
    private final PercentageDiscount percentageDiscount;

    public List<Batch> getAllBatches(){
        return batchRepository.findAll();
    }

    public Registration registerBatch(Long batchId, Long discountId, String email){

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("User not found"));

        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new CustomException("Batch not found"));

        double finalAmount = batch.getFee();
        Discount discount = null;

        if(discountId != null){
            discount = discountRepository.findById(discountId)
                    .orElseThrow(() -> new CustomException("Discount not found"));

            if(discount.getType().equals("FLAT"))
                finalAmount = flatDiscount.calculate(batch.getFee(), discount.getValue());
            else
                finalAmount = percentageDiscount.calculate(batch.getFee(), discount.getValue());
        }

        Registration r = new Registration();
        r.setRegistrationId(UUID.randomUUID().toString());
        r.setStudent(user);
        r.setBatch(batch);
        r.setDiscount(discount);
        r.setFinalAmount(finalAmount);

        return registrationRepository.save(r);
    }

    public List<Registration> myRegistrations(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("User not found"));
        return registrationRepository.findByStudent(user);
    }
}
