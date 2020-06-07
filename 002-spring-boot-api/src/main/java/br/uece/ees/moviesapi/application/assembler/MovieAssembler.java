package br.uece.ees.moviesapi.application.assembler;

import java.time.Year;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import br.uece.ees.moviesapi.domain.model.*;
import org.springframework.stereotype.Component;
import br.uece.ees.moviesapi.application.representation.MovieRepresentation;

@Component
public class MovieAssembler {

    public MovieAssembler() {}

    public Movie toEntity(MovieRepresentation representation) {

        var movie = new Movie();

        movie.setTitle(representation.title);
        movie.setLength(representation.length);
        movie.setSummary(representation.plot_summary);
        movie.setSynopsis(representation.plot_synopsis);
        movie.setDescription(representation.description);
        movie.setReleaseYear(Year.of(representation.release_year));

        List<Category> movieCategories = new ArrayList<>();
        for (var categoryRepresentation : representation.categories)
            movieCategories.add(new Category(categoryRepresentation.id, categoryRepresentation.name));

        movie.setCategories(movieCategories);

        List<CrewMember> crew = new ArrayList<>();
        for (var crewRepresentation : representation.crew) {
            var role    = new FilmCrewRole(crewRepresentation.role_id, crewRepresentation.role_name);
            var member  = new CrewMember(role, crewRepresentation.person_id, crewRepresentation.person_name);
            crew.add(member);
        }
        movie.setCrew(crew);

        List<CastMember> cast = new ArrayList<>();
        for (var castRepresentation : representation.cast) {
            var role    = new ActingRole(castRepresentation.role_id, castRepresentation.role_name);
            var member  = new CastMember(role, castRepresentation.actor_id, castRepresentation.actor_name);
            cast.add(member);
        }
        movie.setCast(cast);

        return movie;
    }

    public Collection<MovieRepresentation> toRepresentationList(Collection<Movie> movies) {
        final List<MovieRepresentation> representations = new ArrayList<>(movies.size());
        for (var movie : movies)
            representations.add(new MovieRepresentation(movie));

        return representations;
    }

}
