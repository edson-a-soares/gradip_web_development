package br.uece.ees.moviesapi.domain.model;

import java.util.Collection;

public interface FilmCrewRoleRepositoryInterface {

	void remove(String id);
	Collection<FilmCrewRole> all();
	FilmCrewRole theOneWith(String id);
	FilmCrewRole theOneOf(String name);
	FilmCrewRole add(FilmCrewRole role);

}
