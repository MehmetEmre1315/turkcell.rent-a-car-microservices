package com.turkcell.Rental.Service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentACarDtoResponse {
    private short id;
    private int carId;
    private short customerId;
    private LocalDate takeCarDate;
    private LocalDate returnCarDate;
    private double totalPrice;
    private boolean isCarAvailable;
    private boolean isCustomerBalanceSufficient;
}
