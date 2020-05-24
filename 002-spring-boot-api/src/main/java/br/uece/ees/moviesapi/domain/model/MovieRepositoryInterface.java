package br.uece.ees.moviesapi.domain.model;

import java.util.Collection;

public interface MovieRepositoryInterface {

	void remove(String id);
	Movie add(Movie movie);
	Collection<Movie> all();
	Movie theOneWith(String id);
	Movie theOneOf(String name);

}
