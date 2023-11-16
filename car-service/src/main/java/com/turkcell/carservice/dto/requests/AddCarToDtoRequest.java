package com.turkcell.carservice.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCarToDtoRequest {
    private int id;
    private String brand;
    private String model;
    private String color;
    private int modelYear;
    private float dailyRentalPrice;
    private String picture;
}
