package br.uece.ees.moviesapi.resource;

import br.uece.ees.moviesapi.domain.model.exception.EntityInUseException;
import br.uece.ees.moviesapi.domain.model.repository.MovieRepositoryInterface;
import br.uece.ees.moviesapi.domain.model.repository.ReviewRepositoryInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import br.uece.ees.moviesapi.domain.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/movies")
public class ReviewsResource {

    @Autowired
    private MovieRepositoryInterface movies;

    @Autowired
	private ReviewRepositoryInterface reviews;

	@GetMapping("/{movieId}/reviews")
	public ResponseEntity<?> list(@PathVariable String movieId) {
        var movie = movies.theOneWith(movieId);
        if (movie == null)
            return ResponseEntity.notFound().build();

		return ResponseEntity.ok(reviews.all(movie));
	}

	@GetMapping("/{movieId}/reviews/{reviewId}")
	public ResponseEntity<Review> find(@PathVariable String reviewId) {
		var review = reviews.theOneWith(reviewId);
		if (review == null)
		    return ResponseEntity.notFound().build();

        return ResponseEntity.ok(review);
	}

	@PostMapping("/{movieId}/reviews")
	public ResponseEntity<?> add(@RequestBody Review review, @PathVariable String movieId) {
		try {
            var movie = movies.theOneWith(movieId);
            if (movie == null)
                return ResponseEntity.notFound().build();

            review.setMovie(movie);
			review = reviews.add(review);
			return ResponseEntity.status(HttpStatus.CREATED).body(review);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@PutMapping("/{movieId}/reviews/{reviewId}")
	public ResponseEntity<?> update(@PathVariable String movieId, @PathVariable String reviewId, @RequestBody Review review) {
		try {
            var movie = movies.theOneWith(movieId);
            if (movie == null)
                return ResponseEntity.notFound().build();

            review.setMovie(movie);
			var localReview = reviews.theOneWith(reviewId);
			if (localReview == null)
				return ResponseEntity.notFound().build();

			BeanUtils.copyProperties(review, localReview, "id");
			localReview = reviews.add(localReview);
			return ResponseEntity.ok(localReview);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@DeleteMapping("/{movieId}/reviews/{reviewId}")
	public ResponseEntity<Movie> remove(@PathVariable String reviewId) {
		try {
			reviews.remove(reviewId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();

		} catch (EntityInUseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
