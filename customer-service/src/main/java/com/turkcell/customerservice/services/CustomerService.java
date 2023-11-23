package com.turkcell.customerservice.services;

import com.turkcell.customerservice.dto.requests.RegisterCustomerRequest;
import com.turkcell.customerservice.dto.responses.RegisterCustomerResponse;

public interface CustomerService {
    RegisterCustomerResponse register(RegisterCustomerRequest request);
}
