package br.uece.ees.moviesapi.domain.model;

import java.util.Collection;

public interface FilmCrewPersonRepositoryInterface {

	void remove(String id);
	Collection<FilmCrewPerson> all();
	FilmCrewPerson personWith(String id);
	FilmCrewPerson personOf(String name);
	FilmCrewPerson add(FilmCrewPerson person);

}
