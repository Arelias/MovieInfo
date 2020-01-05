package com.movies.info.moviesinfo.client;

import com.movies.info.moviesinfo.config.TmdbConfig;
import com.movies.info.moviesinfo.domain.OmdbMovieDto;
import com.movies.info.moviesinfo.domain.OmdbMovieSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class TmdbClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(TmdbClient.class);

    private final RestTemplate restTemplate;

    private final TmdbConfig tmdbConfig;

    public TmdbClient(RestTemplate restTemplate, TmdbConfig tmdbConfig) {
        this.restTemplate = restTemplate;
        this.tmdbConfig = tmdbConfig;
    }

    public List<OmdbMovieDto> searchMoviesPhrase(String phrase) {
        ResponseEntity<OmdbMovieSearch> output;
        URI url = urlBuilder(phrase, "s");
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            output = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), OmdbMovieSearch.class);
            return output.getBody().getSearch();
        } catch (Exception e) {
            LOGGER.info("Exception encountered: searchMoviesPhrase(" + phrase + ")");
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
    }
    //requestentity httpHeaders;
    public OmdbMovieDto searchMovietitle(String phrase) {
        ResponseEntity<OmdbMovieDto> output;
        URI url = urlBuilder(phrase, "t");
        try {
//            HttpHeaders httpHeaders = new HttpHeaders();
            output = restTemplate.exchange(url, HttpMethod.GET, null, OmdbMovieDto.class);
            return output.getBody();
        } catch (Exception e) {
            LOGGER.info("Exception encountered: searchMovieTitle(" + phrase + ")");
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
    }

    private URI urlBuilder(String movieParam, String type) {
        URI url = UriComponentsBuilder.fromHttpUrl(tmdbConfig.getOmdbEndpoint())
                .queryParam("apikey", tmdbConfig.getOmdbKey())
                .queryParam(type, movieParam).build().encode().toUri();
        return url;
    }
}
