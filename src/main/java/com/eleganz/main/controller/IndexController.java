package com.eleganz.main.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eleganz.main.facade.authentication.AuthenticationFacade;

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

	@Value("${app.adminPage}")
	private String adminPage;

	@Value("${app.userPage}")
	private String userPage;

    private AuthenticationFacade authenticationFacade;

	/**
	 * <p>
	 * Constructor for IndexController.
	 * </p>
	 * 
	 * @param authenticationFacade
	 *            a {@link com.eleganz.main.facade.authentication.AuthenticationFacade} object.
	 */
	@Autowired
    public IndexController(AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

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

	/**
	 * <p>
	 * Retrieves the admin page.
	 * </p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/panel", method = GET)
	public ModelAndView panel() {
		final ModelAndView mav;
		Set<String> roles = AuthorityUtils.authorityListToSet(
				authenticationFacade.getAuthentication().getAuthorities());
        if(roles.contains("ROLE_ADMIN")) {
        	mav = new ModelAndView(adminPage);
        } else {
        	mav = new ModelAndView(userPage);
        }
        mav.addObject("env", env);

        return mav;
	}
}
