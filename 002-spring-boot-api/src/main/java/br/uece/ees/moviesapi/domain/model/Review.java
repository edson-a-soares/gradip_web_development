package br.uece.ees.moviesapi.domain.model;

import lombok.Data;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "reviews")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Review {

	@Id
	@Size(max = 36)
	@EqualsAndHashCode.Include
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "review_id", nullable = false)
	private String id;

	@NotNull
	@Column(nullable = false)
	private char rating;

	@Size(max = 500)
	@Column(nullable = true)
	private String comment;

	@NotNull
	@Size(max = 25)
	@Column(name = "reviewer_name", nullable = false)
	private String reviewerName;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;

}
