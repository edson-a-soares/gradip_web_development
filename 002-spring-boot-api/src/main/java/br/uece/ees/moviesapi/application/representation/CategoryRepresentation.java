package br.uece.ees.moviesapi.application.representation;

import br.uece.ees.moviesapi.domain.model.Category;

public class CategoryRepresentation {

    public String id;
    public String name;

    public CategoryRepresentation() {}

    public CategoryRepresentation(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

}
