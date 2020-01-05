package com.movies.info.moviesinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {

    //Timeout and other properties could be added
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
