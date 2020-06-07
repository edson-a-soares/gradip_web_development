package br.uece.ees.moviesapi.domain.model.repository;

import java.util.Collection;
import br.uece.ees.moviesapi.domain.model.Category;

public interface CategoryRepositoryInterface {

	void remove(String id);
	Collection<Category> all();
	Category theOneWith(String id);
	Category theOneOf(String name);
	Category add(Category category);

}
