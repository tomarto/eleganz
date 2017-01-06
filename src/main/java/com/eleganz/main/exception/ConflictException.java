package com.eleganz.main.exception;

/**
 * <p>
 * ConflictException class. Thrown when a conflict is found.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class ConflictException extends RuntimeException {

	/** Constant <code>serialVersionUID=2542212203495145073L</code> */
	private static final long serialVersionUID = 2542212203495145073L;

	/**
	 * <p>
	 * Constructor for ConflictException.
	 * </p>
	 * 
	 */
	public ConflictException() {
		super();
	}

	/**
	 * <p>
	 * Constructor for ConflictException.
	 * </p>
	 * 
	 * @param message
	 *            a {@link java.lang.String} object.
	 */
	public ConflictException(String message) {
		super(message);
	}

	/**
	 * <p>
	 * Constructor for ConflictException.
	 * </p>
	 * 
	 * @param message
	 *            a {@link java.lang.String} object.
	 * @param cause
	 *            a {@link java.lang.Throwable} object.
	 */
	public ConflictException(String message, Throwable cause) {
		super(message, cause);
	}
}
