package com.eleganz.main.controller.login;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleganz.main.facade.authentication.AuthenticationFacade;
import com.eleganz.main.mapper.response.ResponseMapper;
import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.response.Response;
import com.eleganz.main.model.response.user.UserResponse;

/**
 * <p>
 * AuthenticationController class. Controller used to interact with UI.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
@RequestMapping("/api")
public class AuthenticationController {

	private AuthenticationFacade authenticationFacade;
	private final ResponseMapper<User, UserResponse> userResponseMapper;

	/**
	 * <p>
	 * Constructor for AuthenticationController.
	 * </p>
	 * 
	 * @param authenticationFacade
	 *            a {@link com.eleganz.main.facade.authentication.AuthenticationFacade} object.
	 * @param userResponseMapper
	 *            a {@link com.eleganz.main.mapper.response.ResponseMapper<User, UserResponse>} object.
	 */
	@Autowired
	public AuthenticationController(AuthenticationFacade authenticationFacade,
			ResponseMapper<User, UserResponse> userResponseMapper) {
		this.authenticationFacade = authenticationFacade;
		this.userResponseMapper = userResponseMapper;
	}

	/**
	 * <p>
	 * Retrieves the logged in user.
	 * </p>
	 * 
	 * @param principal
	 *            a {@link java.security.Principal} object.
	 * @return a {@link com.eleganz.main.model.response.Response<UserResponse>} object.
	 */
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/authentication", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<UserResponse> getAuthentication() {
		return new Response<>(
				userResponseMapper.convert(authenticationFacade.getSecuredUser().getUser()));
	}
}
