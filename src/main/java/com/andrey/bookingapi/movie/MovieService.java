package com.andrey.bookingapi.movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrey.bookingapi.movie.exception.MovieNotFoundException;
import com.andrey.bookingapi.movie.models.Movie;
import com.andrey.bookingapi.movieslot.models.MovieSlot;
import com.andrey.bookingapi.studio.StudioService;
import com.andrey.bookingapi.studio.models.Studio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final StudioService studioService;

    public List<Movie> getAllMovies(Optional<String> optionalTitle) {
        if (optionalTitle.isPresent()) {
            return this.movieRepository.findByTitleIgnoreCase(optionalTitle.get());
        }
        return this.movieRepository.findAll();
    }

    public Movie findOneById(Long id) {
        return this.movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException());
    }

    public Movie createOne(Movie movie) {

        Studio existingStudio = studioService.getAllStudio().get(0);

        List<MovieSlot> movieSlots = new ArrayList<>();

        LocalDateTime starTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.NOON);

        MovieSlot firstMovieSlot = MovieSlot.builder().jamTayang(starTime).movie(movie).studio(existingStudio)
                .build();
        movieSlots.add(firstMovieSlot);

        for (int i = 0; i < 4; i++) {
            LocalDateTime jamTayang = movieSlots.get(i).getJamTayang();
            LocalDateTime nextJamTayang = jamTayang.plusMinutes((long) (movie.getDuration()));
            MovieSlot nextMovieSlot = MovieSlot.builder().jamTayang(nextJamTayang).movie(movie)
                    .studio(existingStudio).build();
            movieSlots.add(nextMovieSlot);
        }
        movie.setMovieSlots(movieSlots);
        return this.movieRepository.save(movie);
    }

}
