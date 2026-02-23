package com.app.ams.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String discountName;

    private String type; // FLAT / PERCENTAGE

    private double value;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Batch batch;

    @ManyToOne
    private User student;
}
