package com.gmail.ericarnou68.screenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeries(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons") Integer totalSeasons,
                         @JsonAlias("imdbRating") String assessment) {
                        // ensuring correct mapping for deserialization
}
