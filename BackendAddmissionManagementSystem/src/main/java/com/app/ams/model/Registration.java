package com.app.ams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registrationId;

    private double finalAmount;

    @ManyToOne
    private User student;

    @ManyToOne
    private Batch batch;

    @ManyToOne
    private Discount discount;
}
