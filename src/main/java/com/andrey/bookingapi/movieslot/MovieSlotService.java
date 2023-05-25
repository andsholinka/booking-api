package com.andrey.bookingapi.movieslot;

import java.util.List;

import org.springframework.stereotype.Service;
import com.andrey.bookingapi.movieslot.exception.MovieSlotNotFoundException;
import com.andrey.bookingapi.movieslot.models.MovieSlot;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieSlotService {
    private final MovieSlotRepository movieSlotRepository;

    public List<MovieSlot> getAllMovieSlot() {
        return movieSlotRepository.findAll();
    }

    public MovieSlot findOneById(Long id) {
        return movieSlotRepository.findById(id).orElseThrow(() -> new MovieSlotNotFoundException());
    }

    public MovieSlot createOne(MovieSlot movieSlot) {
        return movieSlotRepository.save(movieSlot);
    }
}
