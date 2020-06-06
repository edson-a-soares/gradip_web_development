package br.uece.ees.moviesapi.domain.model.repository;

import java.util.Collection;
import br.uece.ees.moviesapi.domain.model.Movie;

public interface MovieRepositoryInterface {

	void remove(String id);
	Movie add(Movie movie);
	Collection<Movie> all();
	Movie theOneWith(String id);
	Movie theOneOf(String name);

}
