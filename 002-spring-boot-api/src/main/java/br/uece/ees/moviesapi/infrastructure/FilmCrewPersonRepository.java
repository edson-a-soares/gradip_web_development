package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import br.uece.ees.moviesapi.domain.model.FilmCrewPerson;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.FilmCrewPersonRepositoryInterface;

@Component
public class FilmCrewPersonRepository implements FilmCrewPersonRepositoryInterface {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<FilmCrewPerson> all() {
		return manager.createQuery("from FilmCrewPerson", FilmCrewPerson.class).getResultList();
	}

	@Override
	public FilmCrewPerson personWith(String id) {
		return manager.find(FilmCrewPerson.class, id);
	}

	@Override
	public FilmCrewPerson personOf(String name) {
		return null;
	}

	@Override
	@Transactional
	public FilmCrewPerson add(FilmCrewPerson person) {
		return manager.merge(person);

	}

	@Override
	@Transactional
	public void remove(String id) {
		var person = personWith(id);
		if (person == null)
			throw new EmptyResultDataAccessException(1);

		manager.remove(person);
	}

}
