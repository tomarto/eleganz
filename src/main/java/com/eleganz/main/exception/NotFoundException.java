package com.eleganz.main.exception;

/**
 * <p>
 * NotFoundException class. Thrown when a entity is not found.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class NotFoundException extends RuntimeException {

	/** Constant <code>serialVersionUID=-1200595882714392537L</code> */
	private static final long serialVersionUID = -1200595882714392537L;

	/**
	 * <p>
	 * Constructor for NotFoundException.
	 * </p>
	 * 
	 */
	public NotFoundException() {
		super();
	}

	/**
	 * <p>
	 * Constructor for NotFoundException.
	 * </p>
	 * 
	 * @param message
	 *            a {@link java.lang.String} object.
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * <p>
	 * Constructor for NotFoundException.
	 * </p>
	 * 
	 * @param message
	 *            a {@link java.lang.String} object.
	 * @param cause
	 *            a {@link java.lang.Throwable} object.
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
