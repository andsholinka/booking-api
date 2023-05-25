package com.andrey.bookingapi.movie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.bookingapi.movie.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    public Optional<Image> findById(Long id);

}
