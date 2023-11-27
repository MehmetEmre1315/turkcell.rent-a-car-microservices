package com.turkcell.customerservice.repository;

import com.turkcell.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerServiceRepository extends JpaRepository<Customer, Short> {

    Customer findByCustomerId(Short customerId);
}
