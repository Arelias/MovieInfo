package com.movies.info.moviesinfo.service;

import com.movies.info.moviesinfo.domain.User;
import com.movies.info.moviesinfo.repository.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDBService {

    private final UserRepository repository;

    public UserDBService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User findUserById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    public User saveUser(final User user) {
        return repository.save(user);
    }

    public void deleteUser(final Long id) {
        repository.deleteById(id);
    }

    public List<User> findUserByCode(final String userCode) {
        return repository.findByCode(userCode);
    }

    public User findCredentials(final String login, final String password) {
        return repository.findCredentials(login, password).orElse(null);
    }

    public void activateUser(final String userCode) {
        repository.activate(userCode);
    }

    public void changePassword(final String userCode, final String password){
        repository.changePassword(userCode,password);
    }

}
