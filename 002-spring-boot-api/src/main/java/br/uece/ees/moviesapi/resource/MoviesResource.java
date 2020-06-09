package br.uece.ees.moviesapi.resource;

import java.util.Collection;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.uece.ees.moviesapi.domain.model.Movie;
import javax.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;
import br.uece.ees.moviesapi.application.MovieApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import br.uece.ees.moviesapi.application.representation.MovieRepresentation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/movies")
public class MoviesResource {

	@Autowired
	private MovieApplicationService movieApplicationService;


	@GetMapping
	public Collection<MovieRepresentation> list() {
		return movieApplicationService.allMovies();
	}

	@GetMapping("/{movieId}")
	public ResponseEntity<MovieRepresentation> find(@PathVariable String movieId) {
		var movieRepresentation = movieApplicationService.find(movieId);
		if (movieRepresentation.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(movieRepresentation.get());
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody MovieRepresentation representation) {
		try {
			representation = movieApplicationService.addMovie(representation);
			return ResponseEntity.status(HttpStatus.CREATED).body(representation);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{movieId}")
	public ResponseEntity<?> update(@PathVariable String movieId, @RequestBody MovieRepresentation representation) {
		try {
			var localRepresentation = movieApplicationService.find(movieId);
			if (localRepresentation.isEmpty())
				return ResponseEntity.notFound().build();

			BeanUtils.copyProperties(representation, localRepresentation.get(), "id");
			var returnRepresentation = movieApplicationService.addMovie(localRepresentation.get());
			return ResponseEntity.ok(returnRepresentation);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@DeleteMapping("/{movieId}")
	public ResponseEntity<Movie> remove(@PathVariable String movieId) {
		try {
			movieApplicationService.removeMovie(movieId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();

		}
	}

}
