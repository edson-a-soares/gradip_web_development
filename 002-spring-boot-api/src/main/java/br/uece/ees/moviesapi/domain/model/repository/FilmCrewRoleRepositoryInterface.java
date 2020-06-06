package br.uece.ees.moviesapi.domain.model.repository;

import br.uece.ees.moviesapi.domain.model.FilmCrewRole;

import java.util.Collection;

public interface FilmCrewRoleRepositoryInterface {

	void remove(String id);
	Collection<FilmCrewRole> all();
	FilmCrewRole theOneWith(String id);
	FilmCrewRole theOneOf(String name);
	FilmCrewRole add(FilmCrewRole role);

}
