package br.uece.ees.moviesapi.domain.model;

import lombok.Data;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "cast_members")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "actor_id")
public class CastMember extends Actor {

	@OneToOne
	@Size(max = 40)
	@JoinColumn(name = "role_id", nullable = false)
	private ActingRole role;

}
