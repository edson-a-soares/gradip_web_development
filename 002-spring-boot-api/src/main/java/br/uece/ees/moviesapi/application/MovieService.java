package br.uece.ees.moviesapi.application;

import java.util.Optional;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.uece.ees.moviesapi.application.assembler.MovieAssembler;
import br.uece.ees.moviesapi.application.representation.MovieRepresentation;
import br.uece.ees.moviesapi.domain.model.repository.MovieRepositoryInterface;
import br.uece.ees.moviesapi.domain.model.service.AverageRatingCalculatorService;

@Service
public class MovieService {

    private final MovieAssembler assembler;
    private final MovieRepositoryInterface movies;
    private final AverageRatingCalculatorService averageRatingService;

    @Autowired
    public MovieService(MovieRepositoryInterface repository, AverageRatingCalculatorService service, MovieAssembler assembler) {
        movies = repository;
        this.assembler = assembler;
        averageRatingService = service;
    }

    public Optional<MovieRepresentation> find(String movieId) {
        var movie = movies.theOneWith(movieId);
        if (movie == null)
            return Optional.empty();

        return Optional.of(new MovieRepresentation(movie, averageRatingService));
    }

    public Collection<MovieRepresentation> allMovies() {
        return assembler.toRepresentationList(movies.all());
    }

    public MovieRepresentation addMovie(MovieRepresentation representation) {
        var entity = assembler.toEntity(representation);
        return new MovieRepresentation(movies.add(entity));
    }

    public void removeMovie(String movieId) {
        movies.remove(movieId);
    }

}
