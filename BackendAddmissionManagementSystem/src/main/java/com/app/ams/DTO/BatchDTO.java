package com.app.ams.DTO;

import lombok.Data;

@Data
public class BatchDTO {
    private String batchName;
    private double fee;
    private int capacity;
    private String mode;
    private Long courseId;
}
