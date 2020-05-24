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
@Table(name = "acting_roles")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ActingRole {

	@Id
	@Size(max = 36)
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "role_id", nullable = false)
	private String id;

	@NotNull
	@NotEmpty
	@Size(max = 40)
	@Column(name = "role_name", nullable = false)
	private String name;

	@Size(max = 500)
	@Column(name = "role_description")
	private String description;

}
