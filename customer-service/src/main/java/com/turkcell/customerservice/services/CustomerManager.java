package com.turkcell.customerservice.services;

import com.turkcell.customerservice.dto.requests.RegisterCustomerRequest;
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
                .rentalCarId(request.getRentalCarId())
                .isCustomerUseRentalCar(request.isCustomerUseRentalCar())
                .takeCarDate(request.getTakeCarDate())
                .returnCarDate(request.getReturnCarDate())
                .expectedReturnCarDate(request.getExpectedReturnCarDate())
                .phone(request.getPhone())
                .moneyOfCustomer(request.getMoneyOfCustomer())
                .build();
        customer = customerServiceRepository.save(customer);

        RegisterCustomerResponse response = RegisterCustomerResponse.builder()
                .customerId(customer.getCustomerId())
                .lastName(customer.getLastName())
                .firstName(customer.getFirstName())
                .rentalCarId(customer.getRentalCarId())
                .isCustomerUseRentalCar(customer.isCustomerUseRentalCar())
                .takeCarDate(customer.getTakeCarDate())
                .returnCarDate(customer.getReturnCarDate())
                .expectedReturnCarDate(customer.getExpectedReturnCarDate())
                .phone(customer.getPhone())
                .moneyOfCustomer(customer.getMoneyOfCustomer())
                .build();

        return response;
    }
}
