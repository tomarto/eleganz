package com.eleganz.main.model.response;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

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
	private String error;
	private String message;
	private Integer status;
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
	 * @param error
	 *            a {@link java.lang.String} object.
	 * @param status
	 *            a {@link org.springframework.http.HttpStatus} object.
	 */
	public Response(String message, HttpStatus status) {
		this.error = status.getReasonPhrase();
		this.message = message;
		this.status = status.value();
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
	 * Return the error
	 * </p>
	 * 
	 * @return error
	 *            a {@link java.lang.String} object.
	 */
	public String getError() {
		return error;
	}

	/**
	 * <p>
	 * Return the message
	 * </p>
	 * 
	 * @return message
	 *            a {@link java.lang.String} object.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <p>
	 * Return the status
	 * </p>
	 * 
	 * @return status
	 *            a {@link java.lang.String} object.
	 */
	public Integer getStatus() {
		return status;
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

	/**
	 * <p>
	 * Return the errorMessage
	 * </p>
	 * 
	 * @return errorMessage
	 *            a {@link java.lang.String} object.
	 */
	public String getErrorMessage() {
		return errorTime == null ? null : String.format("%s Codigo de error: %s", message, errorTime);
	}
}
