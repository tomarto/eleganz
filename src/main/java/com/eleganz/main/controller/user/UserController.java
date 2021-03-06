package com.eleganz.main.controller.user;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleganz.main.exception.ConflictException;
import com.eleganz.main.exception.NotFoundException;
import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.request.user.UserCreateRequest;
import com.eleganz.main.model.request.user.UserUpdateRequest;
import com.eleganz.main.model.response.Response;
import com.eleganz.main.model.response.user.UserResponse;
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
	private final RequestValidator requestValidator;

	/**
	 * <p>
	 * Constructor for UserController.
	 * </p>
	 * 
	 * @param userService
	 *            a {@link com.eleganz.main.service.user.UserService} object.
	 * @param requestValidator
	 *            a {@link com.eleganz.main.validator.RequestValidator} object.
	 * @param userCreateRequestValidator
	 *            a {@link com.eleganz.main.validator.RequestValidator} object.
	 */
	@Autowired
	public UserController(UserService userService,
			@Qualifier("requestValidator") RequestValidator requestValidator) {
		this.userService = userService;
		this.requestValidator = requestValidator;
	}

	/**
	 * <p>
	 * Retrieves a list of User.
	 * </p>
	 * 
	 * @return a {@link com.eleganz.main.model.response.Response<Collection<UserResponse>>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<Collection<UserResponse>> getUsers() {
		return new Response<>(userService.getAllUsers());
	}

	/**
	 * <p>
	 * Retrieves a single User based on the id.
	 * </p>
	 * 
	 * @param id
	 *            a {@link java.lang.Long} object.
	 * @return a {@link com.eleganz.main.model.response.Response<UserResponse>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<UserResponse> getUser(@PathVariable Long id) {
		return new Response<>(userService.getUserById(id)
				.orElseThrow(() -> new NotFoundException(
						String.format("No se encontró al Usuario con ID: %s", id.toString()))));
	}

	/**
	 * <p>
	 * Create a new user received from the ui.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.user.UserCreateRequest} object.
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user", method = POST, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> createUser(@Valid @RequestBody UserCreateRequest request) {
		requestValidator.validate(request);

		try {
			User user = userService.create(request);
			return new Response<>(String.format("El Usuario %s ha sido creado", user.getUsername()));
		} catch(DataIntegrityViolationException e) {
			throw new ConflictException("El Usuario ya existe", e);
		}
	}

	/**
	 * <p>
	 * Retrieves a single User based on the id.
	 * </p>
	 * 
	 * @param id
	 *            a {@link java.lang.Long} object.
	 * @param request
	 *            a {@link com.eleganz.main.model.request.user.UserRequest} object.
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user/{id}", method = PUT, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> updateUser(@PathVariable Long id,
			@Valid @RequestBody UserUpdateRequest request) {
		requestValidator.validate(request);

		userService.update(id, request);

		return new Response<>(String.format("El Usuario %s se modificó exitosamente", request.getUsername()));
	}

	/**
	 * <p>
	 * Deletes a single User based on the id.
	 * </p>
	 * 
	 * @param id
	 *            a {@link java.lang.Long} object.
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> deleteUser(@PathVariable Long id) {
		userService.delete(id);

		return new Response<>(String.format("El Usuario se eliminó exitosamente"));
	}
}
