package br.uece.ees.moviesapi.api;

import java.util.Collection;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.uece.ees.moviesapi.domain.model.Movie;
import javax.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.uece.ees.moviesapi.domain.model.MovieRepositoryInterface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/movies")
public class MoviesController {

	@Autowired
	private MovieRepositoryInterface movies;

	@GetMapping
	public Collection<Movie> list() {
		return movies.all();
	}

	@GetMapping("/{movieId}")
	public ResponseEntity<Movie> find(@PathVariable String movieId) {
		var movie = movies.theOneWith(movieId);
		if (movie != null)
			return ResponseEntity.ok(movie);

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody Movie movie) {
		try {
			movie = movies.add(movie);
			return ResponseEntity.status(HttpStatus.CREATED).body(movie);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{movieId}")
	public ResponseEntity<?> update(@PathVariable String movieId, @RequestBody Movie movie) {
		try {
			var localMovie = movies.theOneWith(movieId);
			if (localMovie == null)
				return ResponseEntity.notFound().build();

			BeanUtils.copyProperties(movie, localMovie, "id");
			localMovie = movies.add(localMovie);
			return ResponseEntity.ok(localMovie);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@DeleteMapping("/{movieId}")
	public ResponseEntity<Movie> remove(@PathVariable String movieId) {
		try {
			movies.remove(movieId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();

		}
	}

}
