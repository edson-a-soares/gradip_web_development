package br.uece.ees.moviesapi.api;

import java.util.Collection;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.uece.ees.moviesapi.domain.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import br.uece.ees.moviesapi.domain.model.EntityNotFoundException;
import br.uece.ees.moviesapi.domain.model.ActorRepositoryInterface;
import br.uece.ees.moviesapi.domain.model.EntityAlreadyExistsException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/actors")
public class ActorsController {

	@Autowired
	private ActorRepositoryInterface actors;

	@GetMapping
	public Collection<Actor> list() {
		return actors.all();
	}

	@GetMapping("/{actorId}")
	public ResponseEntity<Actor> find(@PathVariable String actorId) {
		var actor = actors.theOneWith(actorId);
		if (actor != null)
			return ResponseEntity.ok(actor);

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody Actor actor) {
		try {
			actor = actors.add(actor);
			return ResponseEntity.status(HttpStatus.CREATED).body(actor);

		} catch (EntityAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PutMapping("/{actorId}")
	public ResponseEntity<?> update(@PathVariable String actorId, @RequestBody Actor actor) {
		try {
			var storedActor = actors.theOneWith(actorId);
			if (storedActor == null)
				return ResponseEntity.notFound().build();

			BeanUtils.copyProperties(actor, storedActor, "id");
			storedActor = actors.add(storedActor);
			return ResponseEntity.ok(storedActor);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{actorId}")
	public ResponseEntity<Actor> remove(@PathVariable String actorId) {
		try {
			actors.remove(actorId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();

		}
	}

}
