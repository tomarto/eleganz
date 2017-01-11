package com.eleganz.main.controller.error;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * ErrorController class. Controller to handle errors.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

	/** Constant <code>PATH="/error"</code> */
	private static final String PATH = "/error";
	private static final Logger LOG = Logger.getLogger(ErrorController.class);

	@Value("${app.env}")
	private String env;

	@Value("${app.errorPage}")
	private String errorPage;

	/**
	 * <p>
	 * Retrieves the error page.
	 * </p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = PATH)
	public ModelAndView error(HttpServletResponse response, Exception e) {
        return buildModelAndViewError(HttpStatus.valueOf(response.getStatus()), e);
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

	/** {@inheritDoc} */
	@Override
	public String getErrorPath() {
		return errorPage;
	}

}
