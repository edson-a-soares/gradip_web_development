package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import br.uece.ees.moviesapi.domain.model.*;
import javax.persistence.PersistenceContext;

import br.uece.ees.moviesapi.domain.model.repository.ReviewRepositoryInterface;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ReviewsRepository implements ReviewRepositoryInterface {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Review> all(Movie movie) {
		var queryBuilder 			= manager.getCriteriaBuilder();
		CriteriaQuery<Review> query = queryBuilder.createQuery(Review.class);
		Root<Review> review 		= query.from(Review.class);

		var equal = queryBuilder.equal(review.get("movie").get("id"), movie.getId());
		query.select(review).where(equal);

		return manager.createQuery(query).getResultList();
	}

	@Override
	public Review theOneWith(String id) {
		return manager.find(Review.class, id);
	}

	@Override
	@Transactional
	public Review add(Review review) {
		return manager.merge(review);

	}

	@Override
	@Transactional
	public void remove(String id) {
		var review = theOneWith(id);
		if (review == null)
			throw new EmptyResultDataAccessException(1);

		manager.remove(review);
	}

}
