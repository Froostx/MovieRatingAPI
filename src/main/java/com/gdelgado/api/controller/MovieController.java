package com.gdelgado.api.controller;

import com.gdelgado.api.model.Movie;
import com.gdelgado.api.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RankingMovies/api")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        //Http status 201 = Created
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity updateMovie(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
        //Http status 200 = Ok
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        return ResponseEntity.ok(movieService.getMovieByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
        //Http status 204 = NO_CONTENT
        return ResponseEntity.status(204).build();
    }

}