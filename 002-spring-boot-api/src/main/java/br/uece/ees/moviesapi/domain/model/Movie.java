package br.uece.ees.moviesapi.domain.model;

import lombok.Data;
import java.time.Year;
import java.util.List;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;
import br.uece.ees.moviesapi.infrastructure.YearAttributeConverter;

@Data
@Entity
@Table(name = "movies")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie {

	@Id
	@Size(max = 36)
	@EqualsAndHashCode.Include
	@Column(name = "movie_id", nullable = false)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotNull
	@NotEmpty
	@Size(max = 40)
	@Column(nullable = false)
	private String title;

	@NotNull
	@Column(name = "length", nullable = false)
	private short length;

	@NotNull
	@NotEmpty
	@Column(name = "plot_synopsis", nullable = false)
	private String synopsis;

	@NotNull
	@NotEmpty
	@Column(name = "plot_summary", nullable = false)
	private String summary;

	@NotNull
	@NotEmpty
	@Column(name = "short_description", nullable = false)
	private String description;

	@NotNull
	@Convert(converter = YearAttributeConverter.class)
	@Column(name = "release_year", nullable = false)
	private Year releaseYear;

	@OneToMany
	@JoinColumn(name = "movie_id", nullable = false)
	private List<CastMember> cast;

	@OneToMany
	@JoinColumn(name = "movie_id", nullable = false)
	private List<CrewMember> crew;

	@ManyToMany
	@JoinTable(
	 	name = "movies_categories",
		joinColumns = { @JoinColumn(name = "movie_id") },
		inverseJoinColumns = { @JoinColumn(name = "category_id") }
	)
	private List<Category> categories;

}
