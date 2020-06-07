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
@Table(name = "categories")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

	public Category() {}

	public Category(String id, String name) {
		this.id   = id;
		this.name = name;
	}

	@Id
	@Size(max = 36)
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "category_id", nullable = false)
	private String id;

	@NotNull
	@NotEmpty
	@Size(max = 40)
	@Column(name = "category_name", nullable = false)
	private String name;

}
