package com.eleganz.main.exception.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.eleganz.main.exception.BadRequestException;
import com.eleganz.main.exception.ConflictException;
import com.eleganz.main.exception.NotFoundException;
import com.eleganz.main.exception.ServerErrorException;
import com.eleganz.main.exception.UnauthorizedException;
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

	@Value("${app.env}")
	private String env;

	@Value("${app.errorPage}")
	private String errorPage;

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
	 * Returns a formatted response with the appropriate response status (401).
	 * </p>
	 * 
	 * @param e
	 *            {@link com.eleganz.main.exception.ServerErrorException}
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value = UnauthorizedException.class)
	public @ResponseBody Response<String> handleUnauthorizedException(ServerErrorException e) {
		final Response<String> errorResult = new Response<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		LOG.error(errorResult.getErrorMessage(), e);
		return errorResult;
	}

	/**
	 * <p>
	 * Redirects a user to an error page depending on the error status.
	 * </p>
	 * 
	 * @param e
	 *            {@link java.lang.Exception}
	 * @return a {@link org.springframework.web.servlet.ModelAndView} object.
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value = AccessDeniedException.class)
	public ModelAndView handleException(AccessDeniedException e) {
		return buildModelAndViewError(HttpStatus.UNAUTHORIZED, e);
	}

	/**
	 * <p>
	 * Build a {@link org.springframework.web.servlet.ModelAndView} for the error page.
	 * </p>
	 * 
	 * @param status
	 *            {@link org.springframework.http.HttpStatus}
	 * @param e
	 *            {@link java.lang.Exception}
	 * @return a {@link org.springframework.web.servlet.ModelAndView} object.
	 */
	private ModelAndView buildModelAndViewError(HttpStatus status, Exception e) {
		final ModelAndView mav = new ModelAndView(errorPage);
		final String message;
		switch (status) {
			case UNAUTHORIZED:
			case FORBIDDEN:
				message = "Lo sentimos, no estás autorizado para entrar a está página.";
				break;
			case NOT_FOUND:
				message = "Lo sentimos, no pudimos encontrar la página que buscabas.";
				break;
			default:
				message = "Lo sentimos, ocurrió un error. Por favor intenta más tarde.";
				break;
		}

		mav.addObject("env", env);
		mav.addObject("message", message);
		mav.addObject("statusCode", status.value());
		mav.addObject("statusMessage", status.getReasonPhrase());
		LOG.error(message, e);

		return mav;
	}
}
