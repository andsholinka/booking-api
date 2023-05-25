package com.andrey.bookingapi.seat.models.dto;

import com.andrey.bookingapi.customer.models.dto.CustomerResponse;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotBookingResponse;

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
public class SeatResponse {
    private Long id;
    private String seatNumber;
    private CustomerResponse customerResponse;
    private MovieSlotBookingResponse movieSlotResponse;
}
