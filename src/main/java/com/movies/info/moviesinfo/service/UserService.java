package com.movies.info.moviesinfo.service;

import com.movies.info.moviesinfo.domain.Mail;
import com.movies.info.moviesinfo.domain.User;
import com.movies.info.moviesinfo.domain.UserCredentials;
import com.movies.info.moviesinfo.validator.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserValidator userValidator;

    private final UserDBService userDBService;

    private final  SimpleEmailService simpleEmailService;


    public UserService(UserValidator userValidator, UserDBService userDBService, SimpleEmailService simpleEmailService) {
        this.userValidator = userValidator;
        this.userDBService = userDBService;
        this.simpleEmailService = simpleEmailService;
    }

    public User userLogIn(UserCredentials credentials) throws Exception {
        int value = 5;
        Integer object = value++;
        System.out.println(object);
        User user = userDBService.findCredentials(credentials.getLogin(), credentials.getPassword());
        if(user.isEmailConfirmed()){
            return user;
        } else {
            throw new Exception("Account is not confirmed, confirm your email.");
        }
    }

    public User userRegistration(User user) throws Exception {
        if(userValidator.validateNewUser(user)){
            userDBService.saveUser(user);
        } else {
            throw new Exception("User data is invalid!");
        }
        String SUBJECT = "MoviesInfo - email confirmation.";
        String MESSAGE = "New account on MoviesInfo has been created, if you didn't create the account, please disregard this email.: ";
        simpleEmailService.send(new Mail(user.getEmail(), SUBJECT, MESSAGE, null),
                user.getUserCode(),
                user.getLogin());
        return user;
    }

    public User userEmailConfirmation(String code) throws Exception {
        List<User> user = userDBService.findUserByCode(code);
        if(user.size() == 1){
            userDBService.activateUser(code);
            return userDBService.findUserByCode(code).get(0);
        } else {
            throw new Exception("No such account or activation expired.");
        }

    }

    public User changePassword(String code, String password) throws Exception {
        List<User> user = userDBService.findUserByCode(code);
        if(user.size() == 1){
            userDBService.changePassword(code,password);
            return userDBService.findUserByCode(code).get(0);
        } else {
            throw new Exception("No such account, please contact support.");
        }
    }
}
