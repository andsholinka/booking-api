package com.andrey.bookingapi.customer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andrey.bookingapi.applicationuser.ApplicationUser;
import com.andrey.bookingapi.customer.models.Customer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Customer save(Customer customer) {

        ApplicationUser applicationUser = customer.getApplicationUser();
        String hashPassword = bCryptPasswordEncoder.encode(applicationUser.getPassword());
        applicationUser.setPassword(hashPassword);

        return customerRepository.save(customer);
    }
}
