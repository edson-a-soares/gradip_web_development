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
	@GenericGenerator(name = "custom-generator", strategy = "uuid")
	private String id;

	@NotNull
	@NotEmpty
	@Size(max = 40)
	@Column(nullable = false)
	private String title;

	@NotNull
	@NotEmpty
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
	@NotEmpty
	@Convert(converter = YearAttributeConverter.class)
	@Column(name = "release_year", nullable = false)
	private Year releaseYear;

	@OneToMany
	@JoinColumn(name = "movie_id", nullable = false)
	List<CastMember> cast;

	@OneToMany
	@JoinColumn(name = "movie_id", nullable = false)
	List<CrewMember> crew;

}