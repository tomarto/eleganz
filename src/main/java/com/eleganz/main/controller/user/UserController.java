package com.eleganz.main.controller.user;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleganz.main.exception.ConflictException;
import com.eleganz.main.exception.NotFoundException;
import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.request.user.UserCreateRequest;
import com.eleganz.main.model.response.Response;
import com.eleganz.main.service.user.UserService;
import com.eleganz.main.validator.RequestValidator;

/**
 * <p>
 * UserController class. Controller used to interact with UI.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
@RequestMapping("/api")
public class UserController {

	private final UserService userService;
	private final RequestValidator userCreateRequestValidator;

	/**
	 * <p>
	 * Constructor for UserController.
	 * </p>
	 * 
	 * @param userService
	 *            a {@link com.eleganz.main.service.user.UserService} object.
	 * @param userCreateRequestValidator
	 *            a {@link com.eleganz.main.validator.RequestValidator} object.
	 */
	@Autowired
	public UserController(UserService userService, RequestValidator userCreateRequestValidator) {
		this.userService = userService;
		this.userCreateRequestValidator = userCreateRequestValidator;
	}

	/**
	 * <p>
	 * Retrieves a list of User.
	 * </p>
	 * 
	 * @return a {@link com.eleganz.main.model.response.Response<Collection<User>>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<Collection<User>> getUsers() {
		return new Response<>(userService.getAllUsers());
	}

	/**
	 * <p>
	 * Retrieves a single User based on the id.
	 * </p>
	 * 
	 * @param id
	 *            a {@link java.lang.Long} object.
	 * @return a {@link com.eleganz.main.model.response.Response<User>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<User> getUser(@PathVariable Long id) {
		return new Response<>(userService.getUserById(id)
				.orElseThrow(() -> new NotFoundException("No se encontró al Usuario")));
	}

	/**
	 * <p>
	 * Retrieves a single User based on the id.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.user.UserCreateRequest} object.
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user", method = POST, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> createUser(@Valid UserCreateRequest request) {
		userCreateRequestValidator.validate(request);

		try {
			userService.create(request);
		} catch(DataIntegrityViolationException e) {
			throw new ConflictException(String.format("El Usuario %s ya existe", request.getUsername()));
		}

		return new Response<>(String.format("El Usuario %s ha sido creado", request.getUsername()));
	}
}
