package br.uece.ees.moviesapi.domain.model;

public class EntityInUseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityInUseException(String message) {
		super(message);
	}

}
