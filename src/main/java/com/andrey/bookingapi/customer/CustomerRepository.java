package com.andrey.bookingapi.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.bookingapi.customer.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
