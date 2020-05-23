package br.uece.ees.moviesapi.domain.model;

import lombok.Data;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "film_crew_people")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FilmCrewPerson {

	@Id
	@Size(max = 36)
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "person_id", nullable = false)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotNull
	@NotEmpty
	@Size(max = 25)
	@Column(name = "person_name", nullable = false)
	private String name;

}
