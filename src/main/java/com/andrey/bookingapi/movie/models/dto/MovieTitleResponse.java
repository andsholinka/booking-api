package com.andrey.bookingapi.movie.models.dto;

import com.andrey.bookingapi.movie.Status;

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
public class MovieTitleResponse {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private double duration;
}
