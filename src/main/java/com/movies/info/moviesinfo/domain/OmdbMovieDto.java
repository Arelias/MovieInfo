package com.movies.info.moviesinfo.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbMovieDto {
    @JsonAlias({"Title"})
    private String title;
    @JsonAlias({"Released"})
    private String released;
    @JsonAlias({"Runtime"})
    private String runtime;
    @JsonAlias({"Genre"})
    private String genre;
    @JsonAlias({"Director"})
    private String director;
    @JsonAlias({"Writer"})
    private String writer;
    @JsonAlias({"Actors"})
    private String actors;
    @JsonAlias({"Plot"})
    private String plot;
    @JsonAlias({"Country"})
    private String country;
    @JsonAlias({"Poster"})
    private String poster;
    private Double imdbRating;
    private String imdbID;

}
