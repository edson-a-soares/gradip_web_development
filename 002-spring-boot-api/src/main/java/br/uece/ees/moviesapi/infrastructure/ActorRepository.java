package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.uece.ees.moviesapi.domain.model.Actor;
import br.uece.ees.moviesapi.domain.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.repository.ActorRepositoryInterface;

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
		var queryBuilder 			= manager.getCriteriaBuilder();
		CriteriaQuery<Actor> query 	= queryBuilder.createQuery(Actor.class);
		Root<Actor> actor			= query.from(Actor.class);

		var equal = queryBuilder.equal(actor.get("name"), name);
		query.select(actor).where(equal);

		var storedActor = manager.createQuery(query).getSingleResult();
		if (storedActor == null)
			throw new EntityNotFoundException();

		return storedActor;
	}

	@Override
	@Transactional
	public Actor add(Actor actor) {
		return manager.merge(actor);

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
