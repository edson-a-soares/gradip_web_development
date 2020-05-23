package br.uece.ees.moviesapi.api;

import java.util.Collection;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import br.uece.ees.moviesapi.domain.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/acting/roles")
public class ActingRolesController {

	@Autowired
	private ActingRoleRepositoryInterface actingRoles;

	@GetMapping
	public Collection<ActingRole> list() {
		return actingRoles.all();
	}

	@GetMapping("/{roleId}")
	public ResponseEntity<ActingRole> find(@PathVariable String roleId) {
		ActingRole role = actingRoles.theOneWith(roleId);
		if (role == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(role);
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody ActingRole role) {
		try {
			role = actingRoles.add(role);
			return ResponseEntity.status(HttpStatus.CREATED).body(role);

		} catch (EntityAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PutMapping("/{roleId}")
	public ResponseEntity<?> update(@PathVariable String roleId, @RequestBody ActingRole role) {
		try {
			ActingRole storedRole = actingRoles.theOneWith(roleId);
			if (storedRole == null)
				return ResponseEntity.notFound().build();

			BeanUtils.copyProperties(role, storedRole, "id");
			storedRole = actingRoles.add(storedRole);
			return ResponseEntity.ok(storedRole);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{roleId}")
	public ResponseEntity<ActingRole> remove(@PathVariable String roleId) {
		try {
			actingRoles.remove(roleId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
