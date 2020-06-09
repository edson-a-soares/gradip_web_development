package br.uece.ees.moviesapi.application.representation;

import java.io.Serializable;
import br.uece.ees.moviesapi.domain.model.Category;

public class CategoryRepresentation implements Serializable {

    public String id;
    public String name;

    public CategoryRepresentation() {}

    public CategoryRepresentation(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

}
