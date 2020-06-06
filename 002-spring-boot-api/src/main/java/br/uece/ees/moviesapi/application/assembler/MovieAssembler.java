package br.uece.ees.moviesapi.application.assembler;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import br.uece.ees.moviesapi.domain.model.Movie;
import br.uece.ees.moviesapi.application.representation.MovieRepresentation;

public class MovieAssembler {

    public static Movie toEntity(MovieRepresentation representation) {
        return null;
    }

    public static Collection<MovieRepresentation> toRepresentationList(Collection<Movie> movies) {
        final List<MovieRepresentation> representations = new ArrayList<>(movies.size());
        for (var movie : movies)
            representations.add(new MovieRepresentation(movie));

        return representations;
    }

}
