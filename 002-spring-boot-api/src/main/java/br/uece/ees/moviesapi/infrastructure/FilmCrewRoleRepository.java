package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import br.uece.ees.moviesapi.domain.model.FilmCrewRole;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.FilmCrewRoleRepositoryInterface;

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
		return null;
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
