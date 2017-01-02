package com.eleganz.main.exception;

/**
 * <p>
 * BadRequestException class. Thrown when a bad request is found.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class BadRequestException extends RuntimeException {

	/** Constant <code>serialVersionUID=2542212203495145073L</code> */
	private static final long serialVersionUID = 2542212203495145073L;

	/**
	 * <p>
	 * Constructor for BadRequestException.
	 * </p>
	 * 
	 */
	public BadRequestException() {
		super();
	}

	/**
	 * <p>
	 * Constructor for BadRequestException.
	 * </p>
	 * 
	 * @param message
	 *            a {@link java.lang.String} object.
	 */
	public BadRequestException(String message) {
		super(message);
	}
}
