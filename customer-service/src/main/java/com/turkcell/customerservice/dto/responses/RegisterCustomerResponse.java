package com.turkcell.customerservice.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterCustomerResponse {
    private short customerId;
    private String lastName;
    private String firstName;
    private String phone;
    private float moneyOfCustomer;
}
