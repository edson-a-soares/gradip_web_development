package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.uece.ees.moviesapi.domain.model.Review;
import org.springframework.stereotype.Component;
import br.uece.ees.moviesapi.domain.model.Category;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.repository.CategoryRepositoryInterface;

@Component
public class CategoryRepository implements CategoryRepositoryInterface {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Category> all() {
		return manager.createQuery("from Category", Category.class).getResultList();
	}

	@Override
	public Category theOneWith(String id) {
		return manager.find(Category.class, id);
	}

	@Override
	public Category theOneOf(String name) {
		var queryBuilder 				= manager.getCriteriaBuilder();
		CriteriaQuery<Category> query 	= queryBuilder.createQuery(Category.class);
		Root<Category> category			= query.from(Category.class);

		var equal = queryBuilder.equal(category.get("name"), name);
		query.select(category).where(equal);

		var storedCategory = manager.createQuery(query).getSingleResult();
		if (storedCategory == null)
			throw new EntityNotFoundException();

		return storedCategory;
	}

	@Override
	@Transactional
	public Category add(Category category) {
		return manager.merge(category);
	}

	@Override
	@Transactional
	public void remove(String id) {
		var actor = theOneWith(id);
		if (actor == null)
			throw new EmptyResultDataAccessException(1);

		manager.remove(actor);
	}

}
