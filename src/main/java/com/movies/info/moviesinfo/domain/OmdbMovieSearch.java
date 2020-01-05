package com.movies.info.moviesinfo.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbMovieSearch {
    @JsonAlias({"Search"})
    private List<OmdbMovieDto> search;

    private Integer totalResults;
}
//    "totalResults": "95",
//    "Response": "True"