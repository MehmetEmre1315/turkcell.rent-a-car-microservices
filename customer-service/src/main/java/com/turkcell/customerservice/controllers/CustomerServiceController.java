package com.turkcell.customerservice.controllers;

import com.turkcell.customerservice.dto.requests.RegisterCustomerRequest;
import com.turkcell.customerservice.dto.responses.RegisterCustomerResponse;
import com.turkcell.customerservice.services.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("CustomerService")
@RestController
@RequiredArgsConstructor
public class CustomerServiceController {
    private final CustomerService customerService;

    @PostMapping("registerCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterCustomerResponse registerCustomer(@RequestBody RegisterCustomerRequest request){
        return customerService.register(request);
    }





}
