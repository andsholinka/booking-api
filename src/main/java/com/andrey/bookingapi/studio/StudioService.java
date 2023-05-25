package com.andrey.bookingapi.studio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andrey.bookingapi.studio.exception.StudioNotFoundException;
import com.andrey.bookingapi.studio.models.Studio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudioService {
    private final StudioRepository studioRepository;

    public List<Studio> getAllStudio() {
        return this.studioRepository.findAll();
    }

    public Studio findOneById(Long id) {
        return this.studioRepository.findById(id).orElseThrow(() -> new StudioNotFoundException());
    }

    public Studio createOne(Studio studio) {
        return this.studioRepository.save(studio);
    }
}
