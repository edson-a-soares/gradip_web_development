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

	public CrewMember() {}

	public CrewMember(FilmCrewRole role, String id, String name) {
		super.setId(id);
		this.role = role;
		super.setName(name);
	}

	@Size(max = 40)
	@OneToOne
	@JoinColumn(name = "role_id", nullable = false)
	private FilmCrewRole role;

}
