package com.movies.info.moviesinfo.controller;

import com.movies.info.moviesinfo.client.OmdbClient;
import com.movies.info.moviesinfo.domain.OmdbMovieDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final OmdbClient omdbClient;

    public MovieController(OmdbClient omdbClient) {
        this.omdbClient = omdbClient;
    }

    @RequestMapping("/phrase/{titlePhrase}")
    public List<OmdbMovieDto> searchPhrase(@PathVariable String titlePhrase) throws Exception {
        List<OmdbMovieDto> output = omdbClient.searchMoviesPhrase(titlePhrase);
        return output;
    }

    @RequestMapping("/title/{movieTitle}")
    public OmdbMovieDto searchMovieTitle(@PathVariable String movieTitle) throws Exception {
        OmdbMovieDto output = omdbClient.searchMovietitle(movieTitle);
        return output;
    }
}