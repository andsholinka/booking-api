package com.andrey.bookingapi.studio.models.dto;

import com.andrey.bookingapi.studio.models.Studio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudioRequest {
    private Long id;
    private String name;
    private int capacity;

    public Studio convertToEntity() {
        return Studio.builder()
                .id(this.id)
                .name(this.name)
                .capacity(this.capacity)
                .build();
    }
}
