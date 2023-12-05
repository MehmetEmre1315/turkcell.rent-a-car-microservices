package com.turkcell.customerservice.controllers;

import com.turkcell.customerservice.dto.requests.GetByIdRequest;
import com.turkcell.customerservice.dto.requests.RegisterCustomerRequest;
import com.turkcell.customerservice.dto.responses.GetByIdResponse;
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

    @PostMapping("getById")
    public GetByIdResponse getCustomer(@RequestBody GetByIdRequest request){
        return customerService.getById(request);
    }

    @PutMapping("updateCustomer")
    @ResponseStatus(HttpStatus.OK)
    public RegisterCustomerResponse updateCustomer(@RequestBody RegisterCustomerRequest request, @RequestParam short customerId){
        return customerService.update(request,customerId);
    }




}
