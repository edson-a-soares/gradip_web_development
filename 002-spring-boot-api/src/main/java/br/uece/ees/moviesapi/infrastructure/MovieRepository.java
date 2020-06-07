package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import br.uece.ees.moviesapi.domain.model.Movie;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.repository.MovieRepositoryInterface;

@Component
public class MovieRepository implements MovieRepositoryInterface {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Movie> all() {
		return manager.createQuery("from Movie", Movie.class).getResultList();
	}

	@Override
	public Movie theOneWith(String id) {
		return manager.find(Movie.class, id);
	}

	@Override
	public Movie theOneOf(String name) {
		return null;
	}

	@Override
	@Transactional
	public Movie add(Movie movie) {
		return manager.merge(movie);
	}

	@Override
	@Transactional
	public void remove(String id) {
		var movie = theOneWith(id);
		if (movie == null)
			throw new EmptyResultDataAccessException(1);

		manager.remove(movie);
	}

}
