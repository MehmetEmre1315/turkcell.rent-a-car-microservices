package com.turkcell.customerservice.services;

import com.turkcell.customerservice.dto.requests.GetByIdRequest;
import com.turkcell.customerservice.dto.requests.RegisterCustomerRequest;
import com.turkcell.customerservice.dto.responses.GetByIdResponse;
import com.turkcell.customerservice.dto.responses.RegisterCustomerResponse;

public interface CustomerService {
    RegisterCustomerResponse register(RegisterCustomerRequest request);
    GetByIdResponse getById(GetByIdRequest request);
}
