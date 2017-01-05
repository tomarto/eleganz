package com.eleganz.main.exception;

/**
 * <p>
 * ServerErrorException class. Thrown when an error in request happens.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class ServerErrorException extends RuntimeException {

	/** Constant <code>serialVersionUID=-3803288290853209381L</code> */
	private static final long serialVersionUID = -3803288290853209381L;

	/**
	 * <p>
	 * Constructor for ServerErrorException.
	 * </p>
	 * 
	 */
	public ServerErrorException() {
		super();
	}

	/**
	 * <p>
	 * Constructor for ServerErrorException.
	 * </p>
	 * 
	 * @param message
	 *            a {@link java.lang.String} object.
	 */
	public ServerErrorException(String message) {
		super(message);
	}
}
