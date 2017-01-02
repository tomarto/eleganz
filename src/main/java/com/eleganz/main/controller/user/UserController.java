package com.eleganz.main.controller.user;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collection;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleganz.main.exception.BadRequestException;
import com.eleganz.main.exception.ConflictException;
import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.request.user.UserCreateRequest;
import com.eleganz.main.model.response.Response;
import com.eleganz.main.service.user.UserService;
import com.eleganz.main.validator.user.UserCreateRequestValidator;

/**
 * <p>
 * UserController class. Controller used to interact with UI.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
public class UserController {

	private final UserService userService;
	private final UserCreateRequestValidator validator;

	/**
	 * <p>
	 * Constructor for UserController.
	 * </p>
	 * 
	 * @param userService
	 *            a {@link com.eleganz.main.service.user.UserService} object.
	 * @param validator
	 *            a {@link com.eleganz.main.validator.user.UserCreateRequestValidator} object.
	 */
	@Autowired
	public UserController(UserService userService, UserCreateRequestValidator validator) {
		this.userService = userService;
		this.validator = validator;
	}

	/**
	 * <p>
	 * Retrieves a list of User.
	 * </p>
	 * 
	 * @return a {@link com.eleganz.main.model.response.Response<Collection<User>>} object.
	 */
	@Secured("ROLE_ADMIN")
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
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/user/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<User> getUser(@PathVariable Long id) {
		return new Response<>(userService.getUserById(id)
				.orElseThrow(() -> new NoSuchElementException(String.format("User with id: %s not found", id))));
	}

	/**
	 * <p>
	 * Retrieves a single User based on the id.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.user.UserCreateRequest} object.
	 * @param bindingResult
	 *            a {@link org.springframework.validation.BindingResult} object.
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/user", method = POST, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> createUser(@Valid UserCreateRequest request, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new BadRequestException("Please verify your inputs");
		}

		validator.validate(request, bindingResult);

		try {
			userService.create(request);
		} catch(DataIntegrityViolationException e) {
			throw new ConflictException("Username already exists");
		}

		return new Response<>("User successfully created");
	}
}
