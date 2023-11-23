package com.turkcell.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
@Builder
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short customerId;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="rental_car_id")
    private short rentalCarId;
    @Column(name="is_customer_use_rental_car")
    private boolean isCustomerUseRentalCar;
    @Column(name="take_car_date")
    private LocalDate takeCarDate;
    @Column(name="return_car_date")
    private LocalDate returnCarDate;
    @Column(name="expected_return_car_date")
    private LocalDate expectedReturnCarDate;
    @Column(name="customer_phone")
    private String phone;
    @Column(name="money_of_customer")
    private short moneyOfCustomer;



}
