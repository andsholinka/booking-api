package com.andrey.bookingapi.movieslot;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andrey.bookingapi.movieslot.models.MovieSlot;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotRequest;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movieslot")
public class MovieSlotController {
    private final MovieSlotService movieSlotService;

    @GetMapping("")
    public ResponseEntity<List<MovieSlotResponse>> getAllMoviesLot(
            @RequestParam("title") Optional<String> optionalTitle) {
        List<MovieSlot> movieSlot = this.movieSlotService.getAllMovieSlot();
        List<MovieSlotResponse> movieResponses = movieSlot.stream().map(m -> m.convertToResponse()).toList();
        return ResponseEntity.status(HttpStatus.OK).body(movieResponses);
    }

    @PostMapping("")
    public ResponseEntity<MovieSlotResponse> createOne(@RequestBody MovieSlotRequest movieSlotRequest) {

        MovieSlot newMovie = movieSlotRequest.convertToEntity();
        MovieSlot saveMovie = this.movieSlotService.createOne(newMovie);
        MovieSlotResponse movieResponse = saveMovie.convertToResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    }
}
