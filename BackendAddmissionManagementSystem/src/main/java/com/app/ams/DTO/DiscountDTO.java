package com.app.ams.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DiscountDTO {
    private String discountName;
    private String type;
    private double value;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long batchId;
}
