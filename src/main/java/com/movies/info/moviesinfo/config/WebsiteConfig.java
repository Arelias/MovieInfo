package com.movies.info.moviesinfo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class WebsiteConfig {
    @Value("${info.website.name}")
    private String websiteName;

    @Value("${info.website.goal}")
    private String websiteGoal;
}
