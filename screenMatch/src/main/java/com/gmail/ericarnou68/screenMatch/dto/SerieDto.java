package com.gmail.ericarnou68.screenMatch.dto;

import com.gmail.ericarnou68.screenMatch.model.Category;

public record SerieDto(
        Long id,
        String title,
        Integer totalSeasons,
        Double assessment,
        Category genre,
        String actors,
        String poster,
        String synopsis) {
}
