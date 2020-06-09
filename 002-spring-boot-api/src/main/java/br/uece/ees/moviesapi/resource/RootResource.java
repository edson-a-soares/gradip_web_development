package br.uece.ees.moviesapi.resource;

import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/")
public class RootResource {

	HttpServletRequest request;

	@Autowired
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@GetMapping
	public ResponseEntity<Map<String, String>> allResources() {
		Map<String, String> resources = new HashMap<>();

		resources.put("actors", getUrl("actors"));
		resources.put("movies", getUrl("movies"));
		resources.put("acting_roles", getUrl("acting/roles"));
		resources.put("film_crew_roles", getUrl("film-crew/roles"));
		resources.put("film_crew_people", getUrl("film-crew/people"));
		resources.put("movies_reviews", getUrl("movies/{movie_id}/reviews"));

		return ResponseEntity.ok(resources);
	}

	private String getUrl(String path) {
		return request.getRequestURL() + path;
	}

}
