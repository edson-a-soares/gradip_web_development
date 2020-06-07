package br.uece.ees.moviesapi.resource;

import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uece.ees.moviesapi.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import br.uece.ees.moviesapi.domain.model.exception.EntityNotFoundException;
import br.uece.ees.moviesapi.domain.model.exception.EntityAlreadyExistsException;
import br.uece.ees.moviesapi.domain.model.repository.CategoryRepositoryInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/categories")
public class CategoriesResource {

	@Autowired
	private CategoryRepositoryInterface categories;

	@GetMapping
	public Collection<Category> list() {
		return categories.all();
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> find(@PathVariable String categoryId) {
		var category = categories.theOneWith(categoryId);
		if (category != null)
			return ResponseEntity.ok(category);

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody Category category) {
		try {
			category = categories.add(category);
			return ResponseEntity.status(HttpStatus.CREATED).body(category);

		} catch (EntityAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<?> update(@PathVariable String categoryId, @RequestBody Category category) {
		try {
			var storedActor = categories.theOneWith(categoryId);
			if (storedActor == null)
				return ResponseEntity.notFound().build();

			BeanUtils.copyProperties(category, storedActor, "id");
			storedActor = categories.add(storedActor);
			return ResponseEntity.ok(storedActor);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Category> remove(@PathVariable String categoryId) {
		try {
			categories.remove(categoryId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();

		}
	}

}
