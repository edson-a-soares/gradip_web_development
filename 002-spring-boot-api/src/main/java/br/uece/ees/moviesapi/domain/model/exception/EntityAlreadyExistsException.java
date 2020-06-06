package br.uece.ees.moviesapi.domain.model.exception;

public class EntityAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityAlreadyExistsException(String message) {
		super(message);
	}

	public EntityAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
