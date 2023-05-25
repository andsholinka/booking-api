package com.andrey.bookingapi.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andrey.bookingapi.customer.models.Customer;
import com.andrey.bookingapi.customer.models.dto.CustomerRequest;
import com.andrey.bookingapi.customer.models.dto.CustomerResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> register(@RequestBody CustomerRequest customerRequest) {
        Customer customer = customerService.save(customerRequest.convertToEntity());
        CustomerResponse customerResponse = customer.convertToResponse();

        return ResponseEntity.ok().body(customerResponse);
    }
}
