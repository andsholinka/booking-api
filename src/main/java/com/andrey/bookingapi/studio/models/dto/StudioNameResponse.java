package com.andrey.bookingapi.studio.models.dto;

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
public class StudioNameResponse {
    private Long id;
    private String name;
    // private int capacity;
    // private Timestamp createdAt;
    // private Timestamp updatedAt;
}
