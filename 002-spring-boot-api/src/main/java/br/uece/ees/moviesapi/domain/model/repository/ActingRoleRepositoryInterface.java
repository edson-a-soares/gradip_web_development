package br.uece.ees.moviesapi.domain.model.repository;

import br.uece.ees.moviesapi.domain.model.ActingRole;

import java.util.Collection;

public interface ActingRoleRepositoryInterface {

	void remove(String id);
	Collection<ActingRole> all();
	ActingRole add(ActingRole role);
	ActingRole theOneWith(String id);
	ActingRole theOneOf(String name);

}
