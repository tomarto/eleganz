package com.eleganz.main.service.user;

import java.util.Collection;
import java.util.Optional;

import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.request.user.UserCreateRequest;

/**
 * <p>
 * UserService interface. Service used for user actions.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface UserService {

	/**
	 * <p>
	 * Retrieves a collection of all {@link com.eleganz.main.model.domain.user.User}.
	 * </p>
	 * 
	 * @return a {@link java.util.Collection<User>} object.
	 */
	Collection<User> getAllUsers();

	/**
	 * <p>
	 * Retrieves a single {@link com.eleganz.main.model.domain.user.User} from its id.
	 * </p>
	 * 
	 * @param id
	 *            {@link java.lang.Long}
	 * @return a {@link java.util.Optional<User>} object.
	 */
	Optional<User> getUserById(long id);

	/**
	 * <p>
	 * Retrieves a single {@link com.eleganz.main.model.domain.user.User} from its username.
	 * </p>
	 * 
	 * @param username
	 *            {@link java.lang.String}
	 * @return a {@link java.util.Optional<User>} object.
	 */
	Optional<User> getUserByUsername(String username);

	/**
	 * <p>
	 * Creates a new {@link com.eleganz.main.model.domain.user.User} from the
	 * {@link com.eleganz.main.model.request.user.UserCreateRequest} request.
	 * </p>
	 * 
	 * @param request
	 *            {@link com.eleganz.main.model.request.user.UserCreateRequest}
	 * @return a {@link com.eleganz.main.model.domain.user.User} object.
	 */
	User create(UserCreateRequest request);
}
