package com.andrey.bookingapi.movieslot.models.dto;

import com.andrey.bookingapi.movieslot.models.MovieSlot;

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
public class MovieSlotBookingRequest {
    private Long id;

    public MovieSlot convertToEntity() {
        return MovieSlot.builder()
                .id(this.id)
                .build();
    }
}
