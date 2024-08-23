package com.gmail.ericarnou68.screenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons") Integer totalSeasons,
                         @JsonAlias("imdbRating") String assessment,
                         @JsonAlias("Genre") String genre,
                         @JsonAlias("Actors") String actors,
                         @JsonAlias("Poster") String poster,
                         @JsonAlias("Plot") String synopsis){
                        // ensuring correct mapping for deserialization
}
