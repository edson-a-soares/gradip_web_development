package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.uece.ees.moviesapi.domain.model.Actor;
import org.springframework.stereotype.Component;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.ActorRepositoryInterface;

@Component
public class ActorRepository implements ActorRepositoryInterface {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<Actor> all() {
		return manager.createQuery("from Actor", Actor.class).getResultList();
	}

	@Override
	public Actor theOneWith(String id) {
		return manager.find(Actor.class, id);
	}

	@Override
	public Actor theOneOf(String name) {
		return null;
	}

	@Override
	@Transactional
	public Actor add(Actor actor) {
		return manager.merge(actor);

	}

	@Override
	@Transactional
	public void remove(String id) {
		Actor actor = theOneWith(id);
		if (actor == null)
			throw new EmptyResultDataAccessException(1);

		manager.remove(actor);
	}

}
