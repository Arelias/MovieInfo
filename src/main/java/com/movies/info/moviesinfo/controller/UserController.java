package com.movies.info.moviesinfo.controller;

import com.movies.info.moviesinfo.client.OmdbClient;
import com.movies.info.moviesinfo.config.AdminConfig;
import com.movies.info.moviesinfo.domain.User;
import com.movies.info.moviesinfo.domain.UserCredentials;
import com.movies.info.moviesinfo.service.SimpleEmailService;
import com.movies.info.moviesinfo.service.UserService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    private final OmdbClient omdbClient;

    private final SimpleEmailService simpleEmailService;

    private final AdminConfig adminConfig;

    private final UserService userService;

    public UserController(OmdbClient omdbClient, SimpleEmailService simpleEmailService, AdminConfig adminConfig, UserService userService) {
        this.omdbClient = omdbClient;
        this.simpleEmailService = simpleEmailService;
        this.adminConfig = adminConfig;
        this.userService = userService;
    }

    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) throws Exception {
        System.out.println();
        user.setData();
        return userService.userRegistration(user);
    }
    @GetMapping("/confirm/{userCode}")
    public User verifyUser(@PathVariable String userCode) throws Exception {
        return userService.userEmailConfirmation(userCode);
    }
    @PutMapping(value = "/resetPassword/{userCode}/{password}")
    public User changePassword(@PathVariable String userCode, @PathVariable String password) throws Exception {
        return userService.changePassword(userCode,password);
    }
    @GetMapping(value = "/login", consumes = APPLICATION_JSON_VALUE)
    public User verifyUser(@RequestBody UserCredentials userCredentials) throws Exception {
        return userService.userLogIn(userCredentials);
    }
}
