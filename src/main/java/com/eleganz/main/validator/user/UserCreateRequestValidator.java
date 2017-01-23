package com.eleganz.main.validator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eleganz.main.exception.BadRequestException;
import com.eleganz.main.exception.ConflictException;
import com.eleganz.main.model.request.user.UserRequest;
import com.eleganz.main.service.user.UserService;
import com.eleganz.main.validator.RequestValidator;

/**
 * <p>
 * UserCreateRequestValidator class.
 * Validator to validate {@link com.eleganz.main.model.request.user.UserRequest}.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component
public class UserCreateRequestValidator extends RequestValidator {

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
	public void validate(Object target) {
		super.validate(target);
		UserRequest request = (UserRequest) target;
		validatePasswords(request);
		validateUsername(request);
	}

	/**
	 * <p>
	 * Verifies that the passwords match.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.user.UserRequest} object.
	 */
	private void validatePasswords(UserRequest request) {
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
	 *            a {@link com.eleganz.main.model.request.user.UserRequest} object.
	 */
	private void validateUsername(UserRequest request) {
		if(userService.getUserByUsername(request.getUsername()).isPresent()) {
			throw new ConflictException("Username already exists");
		}
	}
}
