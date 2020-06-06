package br.uece.ees.moviesapi.domain.model.repository;

import br.uece.ees.moviesapi.domain.model.FilmCrewPerson;

import java.util.Collection;

public interface FilmCrewPersonRepositoryInterface {

	void remove(String id);
	Collection<FilmCrewPerson> all();
	FilmCrewPerson personWith(String id);
	FilmCrewPerson personOf(String name);
	FilmCrewPerson add(FilmCrewPerson person);

}
