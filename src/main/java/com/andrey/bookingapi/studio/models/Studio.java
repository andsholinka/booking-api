package com.andrey.bookingapi.studio.models;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.andrey.bookingapi.movieslot.models.MovieSlot;
import com.andrey.bookingapi.studio.models.dto.StudioNameResponse;
import com.andrey.bookingapi.studio.models.dto.StudioResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int capacity;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "studio")
    // @Cascade(value = CascadeType.ALL)
    private List<MovieSlot> movieSlots;

    public StudioResponse convertStudioResponse() {
        return StudioResponse.builder()
                .id(this.id)
                .name(this.name)
                .capacity(this.capacity)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    public StudioNameResponse convertToResponseStudio() {
        return StudioNameResponse.builder()
                .id(this.id)
                .name(this.name)
                // .capacity(this.capacity)
                // .createdAt(this.createdAt)
                // .updatedAt(this.updatedAt)
                .build();
    }
}
