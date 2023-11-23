package com.turkcell.customerservice.dto.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterCustomerRequest {

    private String lastName;
    private String firstName;
    private short rentalCarId;
    private boolean isCustomerUseRentalCar;
    private LocalDate takeCarDate;
    private LocalDate returnCarDate;
    private LocalDate expectedReturnCarDate;
    private String phone;
    private short moneyOfCustomer;
}
