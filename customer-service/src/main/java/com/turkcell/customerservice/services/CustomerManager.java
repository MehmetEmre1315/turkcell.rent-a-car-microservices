package com.turkcell.customerservice.services;

import com.turkcell.customerservice.repository.CustomerServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerServiceRepository customerServiceRepository;

}
