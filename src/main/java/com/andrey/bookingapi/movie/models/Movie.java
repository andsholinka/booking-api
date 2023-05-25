package com.andrey.bookingapi.movie.models;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.andrey.bookingapi.movie.Status;
import com.andrey.bookingapi.movie.models.dto.MovieResponse;
import com.andrey.bookingapi.movie.models.dto.MovieTitleResponse;
import com.andrey.bookingapi.movieslot.models.MovieSlot;
import com.andrey.bookingapi.movieslot.models.dto.MovieSlotStudioResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Status status;

    private double duration;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Image image;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "movie")
    @Cascade(value = CascadeType.ALL)
    private List<MovieSlot> movieSlots;

    public MovieResponse convertMovieResponse() {
        String imageUrl = image.getUrl();
        List<MovieSlotStudioResponse> movieSlotStudioResponse = this.movieSlots.stream()
                .map(MovieSlot::convertToMovieSlotStudioResponse)
                .toList();

        return MovieResponse.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .status(this.status)
                .duration(this.duration)
                .imageUrl(imageUrl)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .movieSlotStudioResponse(movieSlotStudioResponse)
                .build();
    }

    public MovieTitleResponse convertToResponseTitle() {
        return MovieTitleResponse.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .status(this.status)
                .duration(this.duration)
                .build();
    }
}
