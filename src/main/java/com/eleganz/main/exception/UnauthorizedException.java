package com.eleganz.main.exception;

/**
 * <p>
 * UnauthorizedException class. Thrown when user is not authorized.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UnauthorizedException extends RuntimeException {

	/** Constant <code>serialVersionUID=4832208902986695101L</code> */
	private static final long serialVersionUID = 4832208902986695101L;

	/**
	 * <p>
	 * Constructor for UnauthorizedException.
	 * </p>
	 * 
	 */
	public UnauthorizedException() {
		super();
	}

	/**
	 * <p>
	 * Constructor for UnauthorizedException.
	 * </p>
	 * 
	 * @param message
	 *            a {@link java.lang.String} object.
	 */
	public UnauthorizedException(String message) {
		super(message);
	}

	/**
	 * <p>
	 * Constructor for UnauthorizedException.
	 * </p>
	 * 
	 * @param message
	 *            a {@link java.lang.String} object.
	 * @param cause
	 *            a {@link java.lang.Throwable} object.
	 */
	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}
}
