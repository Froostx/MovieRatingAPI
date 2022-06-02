package com.gdelgado.api.controller;

import com.gdelgado.api.model.Movie;
import com.gdelgado.api.repository.MoviesRepository;
import com.gdelgado.api.services.MovieService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
@Api(tags = "Services")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    private MoviesRepository moviesRepository;

    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie) {
        if(moviesRepository.existsByName(movie.getName())){
            movieService.updateMovie(movie);
        }else moviesRepository.insert(movie);
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

    @DeleteMapping("/{name}")
    public ResponseEntity deleteMovie(@PathVariable String name) {
        movieService.deleteMovie(name);
        //Http status 204 = NO_CONTENT
        return ResponseEntity.status(204).build();
    }

}
