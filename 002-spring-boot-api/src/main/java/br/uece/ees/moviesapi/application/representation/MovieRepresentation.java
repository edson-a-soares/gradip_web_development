package br.uece.ees.moviesapi.application.representation;

import br.uece.ees.moviesapi.domain.model.Category;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;
import br.uece.ees.moviesapi.domain.model.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import br.uece.ees.moviesapi.domain.model.CastMember;
import br.uece.ees.moviesapi.domain.model.CrewMember;
import br.uece.ees.moviesapi.domain.model.service.AverageRatingCalculatorService;

@Data
public class MovieRepresentation {

    private String id;
    private String title;
    private short length;
    private short release_year;
    private String description;
    private String plot_summary;
    private String plot_synopsis;
    private List<String> stars      = new ArrayList<>();
    private List<String> writers    = new ArrayList<>();
    private List<String> directors  = new ArrayList<>();
    private List<String> categories = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private float average_rating;

    public MovieRepresentation(Movie movie) {
        initializeFrom(movie);
    }

    public MovieRepresentation(Movie movie, AverageRatingCalculatorService service) {
        initializeFrom(movie);
        average_rating = service.averageRatingFor(movie);
    }

    private void buildCastRelatedFields(List<CastMember> cast) {
        for (var castMember : cast) {
            if (castMember.getRole().getName().toLowerCase().equals("star"))
                stars.add(castMember.getName());
        }
    }

    private void buildCategories(List<Category> attachedCategories) {
        for (var category : attachedCategories) {
            categories.add(category.getName());
        }
    }

    private void buildCrewRelatedFields(List<CrewMember> crew) {
        for (var crewMember : crew) {
            if (crewMember.getRole().getName().toLowerCase().equals("writer"))
                writers.add(crewMember.getName());

            if (crewMember.getRole().getName().toLowerCase().equals("director"))
                directors.add(crewMember.getName());
        }
    }

    private void initializeFrom(Movie movie) {
        id              = movie.getId();
        title           = movie.getTitle();
        length          = movie.getLength();
        plot_summary    = movie.getSummary();
        plot_synopsis   = movie.getSynopsis();
        description     = movie.getDescription();
        release_year    = (short) movie.getReleaseYear().getValue();

        buildCategories(movie.getCategories());
        buildCastRelatedFields(movie.getCast());
        buildCrewRelatedFields(movie.getCrew());
    }

}
