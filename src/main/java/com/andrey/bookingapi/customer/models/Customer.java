package com.andrey.bookingapi.customer.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.andrey.bookingapi.applicationuser.ApplicationUser;
import com.andrey.bookingapi.customer.models.dto.CustomerResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private ApplicationUser applicationUser;

    // @OneToOne(mappedBy = "customer")
    // @Cascade(value = CascadeType.ALL)
    // private Seat seat;

    public CustomerResponse convertToResponse() {
        return CustomerResponse.builder()
                .id(id)
                .name(name)
                .build();
    }

}
