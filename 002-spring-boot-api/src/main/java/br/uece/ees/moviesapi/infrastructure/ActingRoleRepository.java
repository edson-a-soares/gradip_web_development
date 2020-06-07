package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.uece.ees.moviesapi.domain.model.Actor;
import org.springframework.stereotype.Component;
import br.uece.ees.moviesapi.domain.model.ActingRole;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.repository.ActingRoleRepositoryInterface;

@Component
public class ActingRoleRepository implements ActingRoleRepositoryInterface {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Collection<ActingRole> all() {
		return manager.createQuery("from ActingRole", ActingRole.class).getResultList();
	}

	@Override
	public ActingRole theOneWith(String id) {
		return manager.find(ActingRole.class, id);
	}

	@Override
	public ActingRole theOneOf(String name) {
		var queryBuilder 				= manager.getCriteriaBuilder();
		CriteriaQuery<ActingRole> query = queryBuilder.createQuery(ActingRole.class);
		Root<ActingRole> actingRole		= query.from(ActingRole.class);

		var equal = queryBuilder.equal(actingRole.get("name"), name);
		query.select(actingRole).where(equal);

		var storedRole = manager.createQuery(query).getSingleResult();
		if (storedRole == null)
			throw new EntityNotFoundException();

		return storedRole;
	}

	@Override
	@Transactional
	public ActingRole add(ActingRole role) {
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
