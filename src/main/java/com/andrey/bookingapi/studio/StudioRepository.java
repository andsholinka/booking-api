package com.andrey.bookingapi.studio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.bookingapi.studio.models.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long> {

}
