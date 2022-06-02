package com.gdelgado.api.services;

import com.gdelgado.api.model.Movie;
import com.gdelgado.api.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MoviesRepository moviesRepository;

    public void addMovie(Movie movie) {
        moviesRepository.insert(movie);
    }

    public void updateMovie(Movie movie) {
        Movie savedMovie = moviesRepository.findByName(movie.getName()).orElseThrow(() -> new RuntimeException(String.format
                ("Cannot Find Movie by name", movie.getName())));
        savedMovie.setName(movie.getName());
        savedMovie.setRanking(movie.getRanking());
        savedMovie.setComments(movie.getComments());

        moviesRepository.save(savedMovie);
    }

    public Movie getMovieByName(String name) {
        return moviesRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find Movie by name", name)));
    }

    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    public void deleteMovie(String id) {
        moviesRepository.deleteById(id);
    }

}
