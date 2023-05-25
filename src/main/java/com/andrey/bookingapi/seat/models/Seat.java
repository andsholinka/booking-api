package com.andrey.bookingapi.seat.models;

import com.andrey.bookingapi.customer.models.Customer;
import com.andrey.bookingapi.movieslot.models.MovieSlot;
import com.andrey.bookingapi.seat.models.dto.SeatBookingResponse;
import com.andrey.bookingapi.seat.models.dto.SeatResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "movie_slot_id")
    private MovieSlot movieSlot;

    public SeatBookingResponse convertToBookingResponse() {
        return SeatBookingResponse.builder()
                .id(this.id)
                .seatNumber(this.seatNumber)
                .build();
    }

    public SeatResponse convertToResponse() {
        return SeatResponse.builder()
                .id(this.id)
                .seatNumber(this.seatNumber)
                .customerResponse(this.customer.convertToResponse())
                .movieSlotResponse(this.movieSlot.convertToBookingResponse())
                .build();
    }
}
