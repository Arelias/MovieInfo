package com.movies.info.moviesinfo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class OmdbConfig {
    @Value("${omdb.api.endpoint}")
    private String omdbEndpoint;

    @Value("${omdb.api.key}")
    private String omdbKey;
}
