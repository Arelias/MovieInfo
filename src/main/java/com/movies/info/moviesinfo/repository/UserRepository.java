package com.movies.info.moviesinfo.repository;

import com.movies.info.moviesinfo.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    void deleteById(Long id);

    @Override
    Optional<User> findById(Long id);

    @Override
    long count();

    @Query
    List<User> findByCode(@Param("USERCODE") String accCode);

    @Query
    Optional<User> findCredentials(@Param("LOGIN") String login, @Param("PASSWORD") String password);

    @Query
    @Transactional
    @Modifying
    void activate(@Param("USERCODE") String accCode);

    @Query
    @Transactional
    @Modifying
    void changePassword(@Param("USERCODE") String accCode, @Param("PASSWORD") String password);

}
