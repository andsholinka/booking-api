package com.andrey.bookingapi.seat;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrey.bookingapi.seat.models.Seat;
import com.andrey.bookingapi.seat.models.dto.SeatBookingResponse;
import com.andrey.bookingapi.seat.models.dto.SeatRequest;
import com.andrey.bookingapi.seat.models.dto.SeatResponse;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/seat")
public class SeatController {
    private final SeatService seatService;

    @PostMapping("")
    public ResponseEntity<SeatBookingResponse> createOne(@RequestBody SeatRequest seatRequest) {

        Seat newSeat = seatRequest.convertToEntity();
        Seat saveSeat = this.seatService.createOne(newSeat);
        SeatBookingResponse seatResponse = saveSeat.convertToBookingResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(seatResponse);
    }

    @GetMapping("")
    public ResponseEntity<List<SeatResponse>> findAll() {
        List<Seat> seats = this.seatService.findAll();
        List<SeatResponse> seatResponses = seats.stream().map(seat -> seat.convertToResponse()).toList();
        return ResponseEntity.status(HttpStatus.OK).body(seatResponses);
    }
}
