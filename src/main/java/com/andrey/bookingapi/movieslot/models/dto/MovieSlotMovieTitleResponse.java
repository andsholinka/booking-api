package com.andrey.bookingapi.movieslot.models.dto;

import java.time.LocalDateTime;

import com.andrey.bookingapi.movie.models.dto.MovieTitleResponse;

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
public class MovieSlotMovieTitleResponse {
    private Long id;

    private LocalDateTime jamTayang;

    private MovieTitleResponse movieTitleResponse;
}
