package com.andrey.bookingapi.movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.bookingapi.movie.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public List<Movie> findByTitleIgnoreCase(String title);
}
