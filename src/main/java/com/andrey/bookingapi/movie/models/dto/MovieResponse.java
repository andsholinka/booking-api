package com.andrey.bookingapi.movie.models.dto;

import java.sql.Timestamp;
import java.util.List;

import com.andrey.bookingapi.movie.Status;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotStudioResponse;

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
public class MovieResponse {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private double duration;
    private String imageUrl;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<MovieSlotStudioResponse> movieSlotStudioResponse;
}
