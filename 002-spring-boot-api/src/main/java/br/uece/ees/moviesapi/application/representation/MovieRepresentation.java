package br.uece.ees.moviesapi.application.representation;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import br.uece.ees.moviesapi.domain.model.Movie;
import br.uece.ees.moviesapi.domain.model.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import br.uece.ees.moviesapi.domain.model.CastMember;
import br.uece.ees.moviesapi.domain.model.CrewMember;
import br.uece.ees.moviesapi.domain.model.service.AverageRatingCalculatorService;

public class MovieRepresentation implements Serializable {

    public String id;
    public String title;
    public short length;
    public short release_year;
    public String description;
    public String plot_summary;
    public String plot_synopsis;
    public List<CastRepresentation> cast            = new ArrayList<>();
    public List<CrewRepresentation> crew            = new ArrayList<>();
    public List<CategoryRepresentation> categories  = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public float average_rating;

    public MovieRepresentation(Movie movie) {
        initializeFrom(movie);
    }

    public MovieRepresentation() {}

    public MovieRepresentation(Movie movie, AverageRatingCalculatorService service) {
        initializeFrom(movie);
        average_rating = service.averageRatingFor(movie);
    }

    private void buildCategoriesRepresentation(List<Category> attachedCategories) {
        if (attachedCategories == null)
            return;

        for (var category : attachedCategories)
            categories.add(new CategoryRepresentation(category));
    }

    private void buildCastRepresentation(List<CastMember> castMembers) {
        if (castMembers == null)
            return;

        for (var castMember : castMembers)
            cast.add(new CastRepresentation(castMember));
    }

    private void buildCrewRepresentation(List<CrewMember> crewMembers) {
        if (crewMembers == null)
            return;

        for (var crewMember : crewMembers)
            crew.add(new CrewRepresentation(crewMember));
    }

    private void initializeFrom(Movie movie) {
        id              = movie.getId();
        title           = movie.getTitle();
        length          = movie.getLength();
        plot_summary    = movie.getSummary();
        plot_synopsis   = movie.getSynopsis();
        description     = movie.getDescription();
        release_year    = (short) movie.getReleaseYear().getValue();

        buildCastRepresentation(movie.getCast());
        buildCrewRepresentation(movie.getCrew());
        buildCategoriesRepresentation(movie.getCategories());
    }

}
