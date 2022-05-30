package com.gdelgado.api.repository;

import com.gdelgado.api.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MoviesRepository extends MongoRepository<Movie, String> {
    @Query("{'name': ?0}")
    Optional<Movie> findByName(String name);

    Boolean existsByName(String name);

}