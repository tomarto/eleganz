package com.eleganz.main.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * IndexController class. Start point of the application.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
public class IndexController {

	@Value("${app.env}")
	private String env;

	@Value("${app.welcomePage}")
	private String welcomePage;

	/**
	 * <p>
	 * Retrieves the welcome page.
	 * </p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	@RequestMapping(value = "/", method = GET)
	public ModelAndView welcome() {
		final ModelAndView mav = new ModelAndView(welcomePage);
        mav.addObject("env", env);
        return mav;
	}
}
