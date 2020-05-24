package br.uece.ees.moviesapi.domain.model;

import java.util.Collection;

public interface ActorRepositoryInterface {

	void remove(String id);
	Actor add(Actor actor);
	Collection<Actor> all();
	Actor theOneWith(String id);
	Actor theOneOf(String name);

}
