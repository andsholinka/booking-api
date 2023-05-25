package com.andrey.bookingapi.studio.models.dto;

import java.sql.Timestamp;

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
public class StudioResponse {
    private Long id;
    private String name;
    private int capacity;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
