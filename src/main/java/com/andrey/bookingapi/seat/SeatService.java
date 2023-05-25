package com.andrey.bookingapi.seat;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andrey.bookingapi.seat.models.Seat;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public Seat createOne(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> findAll() {
        return seatRepository.findAll();
    }
}
