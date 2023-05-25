package com.andrey.bookingapi.movie.models.dto;

import com.andrey.bookingapi.movie.Status;
import com.andrey.bookingapi.movie.models.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private long id;
    private String title;
    private String description;
    private Status status;
    private double duration;

    public Movie convertToEntity() {
        return Movie.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .status(this.status)
                .duration(this.duration)
                .build();
    }
}
