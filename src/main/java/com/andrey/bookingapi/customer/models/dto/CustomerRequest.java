package com.andrey.bookingapi.customer.models.dto;

import com.andrey.bookingapi.applicationuser.ApplicationUser;
import com.andrey.bookingapi.customer.models.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;

    public Customer convertToEntity() {
        Customer customer = Customer.builder()
                .id(id)
                .name(name)
                .username(username)
                .email(email)
                .build();

        ApplicationUser applicationUser = ApplicationUser.builder()
                .name(name)
                .username(username)
                .email(email)
                .password(password)
                .build();

        customer.setApplicationUser(applicationUser);
        applicationUser.setCustomer(customer);

        return customer;
    }
}
