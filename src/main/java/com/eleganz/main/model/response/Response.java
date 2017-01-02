package com.eleganz.main.model.response;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Response class. Generic response provided from controllers.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class Response<T> implements Serializable {

	/** Constant <code>serialVersionUID=-1578738188978161351L</code> */
	private static final long serialVersionUID = -1578738188978161351L;

	private T result;
	private String errorMessage;
	private Long errorTime;

	/**
	 * <p>
	 * Constructor for Response.
	 * </p>
	 * 
	 * @param result
	 *            a {@link T} object.
	 */
	public Response(T result) {
		this.result = result;
	}

	/**
	 * <p>
	 * Constructor for Response.
	 * </p>
	 * 
	 * @param errorMessage
	 *            a {@link java.lang.String} object.
	 */
	public Response(String errorMessage) {
		this.errorMessage = errorMessage;
		this.errorTime = new Date().getTime();
	}

	/**
	 * <p>
	 * Return the result
	 * </p>
	 * 
	 * @return result
	 *            a {@link T} object.
	 */
	public T getResult() {
		return result;
	}

	/**
	 * <p>
	 * Return the errorMessage
	 * </p>
	 * 
	 * @return errorMessage
	 *            a {@link java.lang.String} object.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * <p>
	 * Return the errorTime
	 * </p>
	 * 
	 * @return errorTime
	 *            a {@link java.lang.Long} object.
	 */
	public Long getErrorTime() {
		return errorTime;
	}
}
