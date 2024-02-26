package dev.lucin.sevendaysofcode.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Movie {

    @JsonProperty("Title")
    private final String title;

    @JsonProperty("Poster")
    private final String urlImage;

    @JsonProperty("Year")
    private final String year;
}
