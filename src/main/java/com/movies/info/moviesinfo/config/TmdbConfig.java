package com.movies.info.moviesinfo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class TmdbConfig {
    @Value("${tmdb.api.endpoint}")
    private String omdbEndpoint;

    @Value("${tmdb.api.key}")
    private String omdbKey;
}
