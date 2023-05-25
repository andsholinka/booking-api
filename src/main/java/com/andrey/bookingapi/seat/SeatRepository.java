package com.andrey.bookingapi.seat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.bookingapi.seat.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
