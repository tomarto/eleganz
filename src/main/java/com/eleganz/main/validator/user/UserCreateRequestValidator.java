package com.eleganz.main.validator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eleganz.main.exception.BadRequestException;
import com.eleganz.main.exception.ConflictException;
import com.eleganz.main.model.request.user.UserCreateRequest;
import com.eleganz.main.service.user.UserService;

/**
 * <p>
 * UserCreateRequestValidator class.
 * Validator to validate {@link com.eleganz.main.model.request.user.UserCreateRequest}.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component
public class UserCreateRequestValidator implements Validator {

	private final UserService userService;

	/**
	 * <p>
	 * Constructor for UserCreateRequestValidator.
	 * </p>
	 * 
	 * @param userService
	 *            a {@link com.eleganz.main.service.user.UserService} object.
	 */
	@Autowired
	public UserCreateRequestValidator(UserService userService) {
		this.userService = userService;
	}

	/** {@inheritDoc} */
	@Override
	public boolean supports(Class<?> clazz) {
		return UserCreateRequest.class.equals(clazz);
	}

	/** {@inheritDoc} */
	@Override
	public void validate(Object target, Errors errors) {
		UserCreateRequest request = (UserCreateRequest) target;
		validatePasswords(request);
		validateUsername(request);
	}

	/**
	 * <p>
	 * Verifies that the passwords match.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.user.UserCreateRequest} object.
	 */
	private void validatePasswords(UserCreateRequest request) {
		if(!request.getPassword().equals(request.getPasswordRepeat())) {
			throw new BadRequestException("Passwords does not match");
		}
	}

	/**
	 * <p>
	 * Verifies that the username is unique.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.user.UserCreateRequest} object.
	 */
	private void validateUsername(UserCreateRequest request) {
		if(userService.getUserByUsername(request.getUsername()).isPresent()) {
			throw new ConflictException("Username already exists");
		}
	}
}
