package br.uece.ees.moviesapi.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.time.Year;
import java.util.List;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;
import br.uece.ees.moviesapi.infrastructure.YearAttributeConverter;

@Entity
@Table(name = "movies")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie {

	@Id
	@Getter
	@Setter
	@Size(max = 36)
	@EqualsAndHashCode.Include
	@Column(name = "movie_id", nullable = false)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Getter
	@Setter
	@NotNull
	@NotEmpty
	@Size(max = 40)
	@Column(nullable = false)
	private String title;

	@Getter
	@Setter
	@NotNull
	@NotEmpty
	@Column(name = "length", nullable = false)
	private short length;

	@Getter
	@Setter
	@NotNull
	@NotEmpty
	@Column(name = "plot_synopsis", nullable = false)
	private String synopsis;

	@Getter
	@Setter
	@NotNull
	@NotEmpty
	@Column(name = "plot_summary", nullable = false)
	private String summary;

	@Getter
	@Setter
	@NotNull
	@NotEmpty
	@Column(name = "short_description", nullable = false)
	private String description;

	@Getter
	@Setter
	@NotNull
	@NotEmpty
	@Convert(converter = YearAttributeConverter.class)
	@Column(name = "release_year", nullable = false)
	private Year releaseYear;

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "movie_id", nullable = false)
	private List<CastMember> cast;

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "movie_id", nullable = false)
	private List<CrewMember> crew;

}