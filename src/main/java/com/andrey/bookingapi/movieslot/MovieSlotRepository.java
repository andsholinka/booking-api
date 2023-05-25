package com.andrey.bookingapi.movieslot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.bookingapi.movie.models.Movie;
import com.andrey.bookingapi.movieslot.models.MovieSlot;

public interface MovieSlotRepository extends JpaRepository<MovieSlot, Long> {
    public List<MovieSlot> findByMovie(Movie movie);
}
