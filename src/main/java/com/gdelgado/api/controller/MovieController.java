package com.gdelgado.api.controller;

import com.gdelgado.api.model.Movie;
import com.gdelgado.api.repository.MoviesRepository;
import com.gdelgado.api.services.MovieService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie) {
        if(moviesRepository.existsByName(movie.getName())){
            movieService.updateMovie(movie);
        }else moviesRepository.insert(movie);
        //Http status 201 = Created
        return new ResponseEntity(movie, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateMovie(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
        //Http status 200 = Ok
        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        return ResponseEntity.ok(movieService.getMovieByName(name));
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMovie(@RequestBody @PathVariable String name) {
        movieService.deleteMovie(name);
        //Http status 204 = NO_CONTENT
        return new ResponseEntity(name, HttpStatus.NO_CONTENT);
    }

}
