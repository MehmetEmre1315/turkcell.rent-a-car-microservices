package com.turkcell.Rental.Service.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentACarDtoRequest {
    private int carId;
    private short customerId;
    private LocalDate takeCarDate;
    private LocalDate returnCarDate;
}
