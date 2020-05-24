package br.uece.ees.moviesapi.domain.model;

import lombok.Data;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "film_crew_members")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "person_id")
public class CrewMember extends FilmCrewPerson {

	@Size(max = 40)
	@OneToOne
	@JoinColumn(name = "role_id", nullable = false)
	private FilmCrewRole role;

}
