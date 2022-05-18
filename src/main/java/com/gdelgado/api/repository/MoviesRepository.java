package com.gdelgado.api.repository;

import com.gdelgado.api.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoviesRepository extends MongoRepository<Movie, String> {
}
