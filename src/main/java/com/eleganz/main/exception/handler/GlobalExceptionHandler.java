package com.eleganz.main.exception.handler;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eleganz.main.exception.BadRequestException;
import com.eleganz.main.exception.ConflictException;
import com.eleganz.main.exception.NotFoundException;
import com.eleganz.main.exception.ServerErrorException;
import com.eleganz.main.model.response.Response;

/**
 * <p>
 * GlobalExceptionHandler class. Handles all the exceptions thrown from Controllers.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

	/**
	 * <p>
	 * Returns a formatted response with the appropriate response status (400).
	 * </p>
	 * 
	 * @param e
	 *            {@link com.eleganz.main.exception.BadRequestException}
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BadRequestException.class)
	public @ResponseBody Response<String> handleBadRequestException(BadRequestException e) {
		final Response<String> errorResult = new Response<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		LOG.error(errorResult.getErrorMessage(), e);
		return errorResult;
	}

	/**
	 * <p>
	 * Returns a formatted response with the appropriate response status (404).
	 * </p>
	 * 
	 * @param e
	 *            {@link com.eleganz.main.exception.NotFoundException}
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = NotFoundException.class)
	public @ResponseBody Response<String> handleNotFoundException(NotFoundException e) {
		final Response<String> errorResult = new Response<>(e.getMessage(), HttpStatus.NOT_FOUND);
		LOG.error(errorResult.getErrorMessage(), e);
		return errorResult;
	}

	/**
	 * <p>
	 * Returns a formatted response with the appropriate response status (409).
	 * </p>
	 * 
	 * @param e
	 *            {@link com.eleganz.main.exception.ConflictException}
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(value = ConflictException.class)
	public @ResponseBody Response<String> handleConflictException(ConflictException e) {
		final Response<String> errorResult = new Response<>(e.getMessage(), HttpStatus.CONFLICT);
		LOG.error(errorResult.getErrorMessage(), e);
		return errorResult;
	}

	/**
	 * <p>
	 * Returns a formatted response with the appropriate response status (500).
	 * </p>
	 * 
	 * @param e
	 *            {@link com.eleganz.main.exception.ServerErrorException}
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = ServerErrorException.class)
	public @ResponseBody Response<String> handleServerErrorException(ServerErrorException e) {
		final Response<String> errorResult = new Response<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		LOG.error(errorResult.getErrorMessage(), e);
		return errorResult;
	}

	/**
	 * <p>
	 * Returns a formatted response with the appropriate response status (500).
	 * </p>
	 * 
	 * @param e
	 *            {@link java.lang.Exception}
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public @ResponseBody Response<String> handleException(Exception e) {
		final Response<String> errorResult = 
				new Response<>("Ocurrió un error. Por favor intenta más tarde.", HttpStatus.INTERNAL_SERVER_ERROR);
		LOG.error(errorResult.getErrorMessage(), e);
		return errorResult;
	}
}
