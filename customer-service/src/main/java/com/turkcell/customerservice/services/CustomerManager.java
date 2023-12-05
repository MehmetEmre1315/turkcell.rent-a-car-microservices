package com.turkcell.customerservice.services;

import com.turkcell.customerservice.dto.requests.GetByIdRequest;
import com.turkcell.customerservice.dto.requests.RegisterCustomerRequest;
import com.turkcell.customerservice.dto.responses.GetByIdResponse;
import com.turkcell.customerservice.dto.responses.RegisterCustomerResponse;
import com.turkcell.customerservice.entities.Customer;
import com.turkcell.customerservice.repository.CustomerServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerServiceRepository customerServiceRepository;

    @Override
    public RegisterCustomerResponse register(RegisterCustomerRequest request) {
        Customer customer = Customer.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .phone(request.getPhone())
                .moneyOfCustomer(request.getMoneyOfCustomer())
                .build();
        customer = customerServiceRepository.save(customer);

        RegisterCustomerResponse response = RegisterCustomerResponse.builder()
                .customerId(customer.getCustomerId())
                .lastName(customer.getLastName())
                .firstName(customer.getFirstName())
                .phone(customer.getPhone())
                .moneyOfCustomer(customer.getMoneyOfCustomer())
                .build();

        return response;
    }

    @Override
    public GetByIdResponse getById(GetByIdRequest request) {
        Customer customer = customerServiceRepository.findByCustomerId(request.getCustomerId());

        GetByIdResponse response = GetByIdResponse.builder()
                .customerId(customer.getCustomerId())
                .lastName(customer.getLastName())
                .firstName(customer.getFirstName())
                .phone(customer.getPhone())
                .moneyOfCustomer(customer.getMoneyOfCustomer())
                .build();

        return response;
    }

    @Override
    public RegisterCustomerResponse update(RegisterCustomerRequest request, short customerId) {
        Customer existingCustomer = customerServiceRepository.findByCustomerId(customerId);

        existingCustomer.setLastName(request.getLastName());
        existingCustomer.setFirstName(request.getFirstName());
        existingCustomer.setPhone(request.getPhone());
        existingCustomer.setMoneyOfCustomer(request.getMoneyOfCustomer());
        customerServiceRepository.save(existingCustomer);

        RegisterCustomerResponse response = RegisterCustomerResponse.builder()
                .customerId(existingCustomer.getCustomerId())
                .lastName(existingCustomer.getLastName())
                .firstName(existingCustomer.getFirstName())
                .phone(existingCustomer.getPhone())
                .moneyOfCustomer(existingCustomer.getMoneyOfCustomer())
                .build();

        return response;
    }
}
