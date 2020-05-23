package br.uece.ees.moviesapi.api;

import java.util.Collection;
import br.uece.ees.moviesapi.domain.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/film-crew/roles")
public class FilmCrewRolesController {

	@Autowired
	private FilmCrewRoleRepositoryInterface filmCrewRoles;

	@GetMapping
	public Collection<FilmCrewRole> list() {
		return filmCrewRoles.all();
	}

	@GetMapping("/{roleId}")
	public ResponseEntity<FilmCrewRole> find(@PathVariable String roleId) {
		FilmCrewRole role = filmCrewRoles.theOneWith(roleId);
		if (role == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(role);
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody FilmCrewRole role) {
		try {
			role = filmCrewRoles.add(role);
			return ResponseEntity.status(HttpStatus.CREATED).body(role);

		} catch (EntityAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PutMapping("/{roleId}")
	public ResponseEntity<?> update(@PathVariable String roleId, @RequestBody FilmCrewRole role) {
		try {
			FilmCrewRole storedRole = filmCrewRoles.theOneWith(roleId);
			if (storedRole == null)
				return ResponseEntity.notFound().build();

			BeanUtils.copyProperties(role, storedRole, "id");
			storedRole = filmCrewRoles.add(storedRole);
			return ResponseEntity.ok(storedRole);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{roleId}")
	public ResponseEntity<FilmCrewRole> remove(@PathVariable String roleId) {
		try {
			filmCrewRoles.remove(roleId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
