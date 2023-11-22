package com.turkcell.customerservice.controllers;

import com.turkcell.customerservice.services.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("CustomerService")
@RestController
@RequiredArgsConstructor
public class CustomerServiceController {
    private final CustomerService customerService;

    @GetMapping()
    public int returnInt(){
        int i = 5;
        return i;

    }


}
