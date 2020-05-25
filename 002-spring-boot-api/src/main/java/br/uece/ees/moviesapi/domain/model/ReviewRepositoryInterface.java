package br.uece.ees.moviesapi.domain.model;

import java.util.Collection;

public interface ReviewRepositoryInterface {

	void remove(String id);
	Review add(Review review);
	Review theOneWith(String id);
	Collection<Review> all(Movie movie);

}
