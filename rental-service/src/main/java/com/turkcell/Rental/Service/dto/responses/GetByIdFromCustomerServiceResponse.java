package com.turkcell.Rental.Service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdFromCustomerServiceResponse {

    private short customerId;
    private String lastName;
    private String firstName;
    private String phone;
    private float moneyOfCustomer;
}
