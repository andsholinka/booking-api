package com.andrey.bookingapi.movieslot.models.dto;

import java.time.LocalDateTime;

import com.andrey.bookingapi.movieslot.models.MovieSlot;
import com.andrey.bookingapi.studio.models.dto.StudioRequest;
import com.andrey.bookingapi.movie.models.dto.MovieRequest;

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
public class MovieSlotRequest {
    private Long id;
    private LocalDateTime jamTayang;
    private MovieRequest movieRequest;
    private StudioRequest studioRequest;

    public MovieSlot convertToEntity() {
        return MovieSlot.builder()
                .id(this.id)
                .jamTayang(this.jamTayang)
                .movie(this.movieRequest.convertToEntity())
                .studio(this.studioRequest.convertToEntity())
                .build();
    }
}
