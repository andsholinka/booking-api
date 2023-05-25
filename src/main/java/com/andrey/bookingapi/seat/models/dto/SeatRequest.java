package com.andrey.bookingapi.seat.models.dto;

import com.andrey.bookingapi.customer.models.dto.CustomerRequest;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotBookingRequest;
import com.andrey.bookingapi.seat.models.Seat;

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
public class SeatRequest {
    private Long id;
    private String seatNumber;
    private CustomerRequest customerRequest;
    private MovieSlotBookingRequest movieSlotRequest;

    public Seat convertToEntity() {
        return Seat.builder()
                .id(this.id)
                .seatNumber(this.seatNumber)
                .customer(this.customerRequest.convertToEntity())
                .movieSlot(this.movieSlotRequest.convertToEntity())
                .build();
    }
}
