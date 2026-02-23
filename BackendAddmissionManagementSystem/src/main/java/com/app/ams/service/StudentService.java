package com.app.ams.service;

import java.util.List;

import com.app.ams.model.Batch;
import com.app.ams.model.Registration;

public interface StudentService {
    List<Batch> getAllBatches();
    Registration registerBatch(Long batchId, Long discountId, String email);
    List<Registration> myRegistrations(String email);
}
