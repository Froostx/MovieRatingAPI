package com.gdelgado.api.controller;

import com.gdelgado.api.model.Movie;
import com.gdelgado.api.repository.MoviesRepository;
import com.gdelgado.api.resource.MoviesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    private final MoviesRepository moviesRepository;

    public MovieController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(this.moviesRepository.findAll());
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie (@RequestBody MoviesRequest moviesRequest) {

        Movie movie = new Movie();
        movie.setName(moviesRequest.getName());
        movie.setRanking(moviesRequest.getRanking());
        movie.setComments(moviesRequest.getComments());

        return ResponseEntity.status(201).body(this.moviesRepository.save(movie));
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity getMovieById(@PathVariable String id) {

        Optional<Movie> movieMapping = this.moviesRepository.findById(id);

        if(movieMapping.isPresent()) {
            return ResponseEntity.ok(movieMapping.get());
        } else {
            return ResponseEntity.ok("The movie with id: " + id + " was not found.");
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity deleteMovieById(@PathVariable String id) {

        Optional<Movie> movieDelete = this.moviesRepository.findById(id);

        if(movieDelete.isPresent()) {
            this.moviesRepository.deleteById(id);
            return ResponseEntity.ok("Movie deleted successfully");
        } else {
            return ResponseEntity.ok("The movie with id: " + id + " was not found.");
        }
    }
}
