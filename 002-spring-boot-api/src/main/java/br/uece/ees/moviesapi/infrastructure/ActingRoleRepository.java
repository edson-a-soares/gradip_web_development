package br.uece.ees.moviesapi.infrastructure;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import br.uece.ees.moviesapi.domain.model.ActingRole;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import br.uece.ees.moviesapi.domain.model.ActingRoleRepositoryInterface;

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
		return null;
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
