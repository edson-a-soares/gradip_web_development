package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.uece.ees.moviesapi.domain.model.Category;
import org.springframework.stereotype.Component;
import br.uece.ees.moviesapi.domain.model.FilmCrewRole;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.repository.FilmCrewRoleRepositoryInterface;

@Component
public class FilmCrewRoleRepository implements FilmCrewRoleRepositoryInterface {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<FilmCrewRole> all() {
		return manager.createQuery("from FilmCrewRole", FilmCrewRole.class).getResultList();
	}

	@Override
	public FilmCrewRole theOneWith(String id) {
		return manager.find(FilmCrewRole.class, id);
	}

	@Override
	public FilmCrewRole theOneOf(String name) {
		var queryBuilder 					= manager.getCriteriaBuilder();
		CriteriaQuery<FilmCrewRole> query 	= queryBuilder.createQuery(FilmCrewRole.class);
		Root<FilmCrewRole> filmCrewRole		= query.from(FilmCrewRole.class);

		var equal = queryBuilder.equal(filmCrewRole.get("name"), name);
		query.select(filmCrewRole).where(equal);

		var storedRole = manager.createQuery(query).getSingleResult();
		if (storedRole == null)
			throw new EntityNotFoundException();

		return storedRole;
	}

	@Override
	@Transactional
	public FilmCrewRole add(FilmCrewRole role) {
		return manager.merge(role);

	}

	@Override
	@Transactional
	public void remove(String id) {
		var role = theOneWith(id);
		if (role == null)
			throw new EmptyResultDataAccessException(1);

		manager.remove(role);
	}

}
