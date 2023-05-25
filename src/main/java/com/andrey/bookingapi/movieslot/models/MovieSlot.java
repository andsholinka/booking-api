package com.andrey.bookingapi.movieslot.models;

import java.time.LocalDateTime;

import com.andrey.bookingapi.movie.models.Movie;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotBookingResponse;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotResponse;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotStudioResponse;
import com.andrey.bookingapi.studio.models.Studio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity
public class MovieSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime jamTayang;

    @ManyToOne
    // @Cascade(value = CascadeType.ALL)
    // @JsonBackReference
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    // @Cascade(value = CascadeType.ALL)
    // @JsonBackReference
    @JoinColumn(name = "studio_id")
    private Studio studio;

    public MovieSlotResponse convertToResponse() {
        return MovieSlotResponse.builder()
                .id(this.id)
                .jamTayang(this.jamTayang)
                .movieResponse(this.movie.convertToResponseTitle())
                .studioResponse(this.studio.convertToResponseStudio())
                .build();
    }

    public MovieSlotStudioResponse convertToMovieSlotStudioResponse() {
        return MovieSlotStudioResponse.builder()
                .id(this.id)
                .jamTayang(this.jamTayang)
                .studioNameResponse(this.studio.convertToResponseStudio())
                .build();
    }

    public MovieSlotBookingResponse convertToBookingResponse() {
        return MovieSlotBookingResponse.builder()
                .id(this.id)
                .jamTayang(this.jamTayang)
                .movieResponse(this.movie.convertToResponseTitle())
                .studioResponse(this.studio.convertToResponseStudio())
                .build();
    }
}
