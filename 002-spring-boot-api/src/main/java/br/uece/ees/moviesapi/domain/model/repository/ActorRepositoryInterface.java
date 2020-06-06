package br.uece.ees.moviesapi.domain.model.repository;

import br.uece.ees.moviesapi.domain.model.Actor;

import java.util.Collection;

public interface ActorRepositoryInterface {

	void remove(String id);
	Actor add(Actor actor);
	Collection<Actor> all();
	Actor theOneWith(String id);
	Actor theOneOf(String name);

}
