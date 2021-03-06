package br.uece.ees.moviesapi.resource;

import java.util.Collection;

import br.uece.ees.moviesapi.domain.model.exception.EntityAlreadyExistsException;
import br.uece.ees.moviesapi.domain.model.exception.EntityNotFoundException;
import br.uece.ees.moviesapi.domain.model.*;
import br.uece.ees.moviesapi.domain.model.repository.FilmCrewPersonRepositoryInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/film-crew/people")
public class FilmCrewPeopleResource {

	@Autowired
	private FilmCrewPersonRepositoryInterface filmCrewPeople;

	@GetMapping
	public Collection<FilmCrewPerson> list() {
		return filmCrewPeople.all();
	}

	@GetMapping("/{personId}")
	public ResponseEntity<FilmCrewPerson> find(@PathVariable String personId) {
		var person = filmCrewPeople.personWith(personId);
		if (person == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(person);
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody FilmCrewPerson person) {
		try {
			person = filmCrewPeople.add(person);
			return ResponseEntity.status(HttpStatus.CREATED).body(person);

		} catch (EntityAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PutMapping("/{personId}")
	public ResponseEntity<?> update(@PathVariable String personId, @RequestBody FilmCrewPerson person) {
		try {
			var storedPerson = filmCrewPeople.personWith(personId);
			if (storedPerson == null)
				return ResponseEntity.notFound().build();

			BeanUtils.copyProperties(person, storedPerson, "id");
			storedPerson = filmCrewPeople.add(storedPerson);
			return ResponseEntity.ok(storedPerson);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{personId}")
	public ResponseEntity<FilmCrewPerson> remove(@PathVariable String personId) {
		try {
			filmCrewPeople.remove(personId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
