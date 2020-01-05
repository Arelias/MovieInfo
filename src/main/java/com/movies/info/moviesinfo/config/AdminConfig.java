package com.movies.info.moviesinfo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Component
public final class AdminConfig {
    @Value("${admin.name}")
    private String adminName;

    @Value("${admin.mail}")
    private String adminMail;
}
