package com.movies.info.moviesinfo.validator;

import com.movies.info.moviesinfo.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public boolean validateNewUser(User user){
        if(!user.getEmail().contains("@")){
            return false;
        }
        if(user.getLogin().length() < 5){
            return false;
        }
        if(user.getPassword().length() < 5){
            return false;
        }
        return true;
    }
}
