package com.andrey.bookingapi.movieslot.models.dto;

import java.time.LocalDateTime;

import com.andrey.bookingapi.movie.models.dto.MovieTitleResponse;
import com.andrey.bookingapi.studio.models.dto.StudioNameResponse;

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
public class MovieSlotResponse {
    private Long id;

    private LocalDateTime jamTayang;

    private MovieTitleResponse movieResponse;

    private StudioNameResponse studioResponse;
}
