package com.eleganz.main.service.user;

import java.util.Collection;
import java.util.Optional;

import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.request.user.UserRequest;
import com.eleganz.main.model.request.user.UserUpdateRequest;
import com.eleganz.main.model.response.user.UserResponse;

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
	 * Retrieves a collection of all {@link com.eleganz.main.model.response.user.UserResponse}.
	 * </p>
	 * 
	 * @return a {@link java.util.Collection<UserResponse>} object.
	 */
	Collection<UserResponse> getAllUsers();

	/**
	 * <p>
	 * Retrieves a single {@link com.eleganz.main.model.response.user.UserResponse} from its id.
	 * </p>
	 * 
	 * @param id
	 *            {@link java.lang.Long}
	 * @return a {@link java.util.Optional<UserResponse>} object.
	 */
	Optional<UserResponse> getUserById(long id);

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
	 * Creates a new {@link com.eleganz.main.model.response.user.UserResponse} from the
	 * {@link com.eleganz.main.model.request.user.UserRequest} request.
	 * </p>
	 * 
	 * @param request
	 *            {@link com.eleganz.main.model.request.user.UserRequest}
	 * @return a {@link com.eleganz.main.model.response.user.UserResponse} object.
	 */
	UserResponse create(UserRequest request);

	/**
	 * <p>
	 * Updates a {@link com.eleganz.main.model.domain.user.User} from the
	 * {@link com.eleganz.main.model.request.user.UserUpdateRequest} request.
	 * </p>
	 * 
	 * @param id
	 *            {@link java.lang.Long}
	 * @param request
	 *            {@link com.eleganz.main.model.request.user.UserUpdateRequest}
	 */
	void update(Long id, UserUpdateRequest request);

	/**
	 * <p>
	 * Deletes a {@link com.eleganz.main.model.domain.user.User}.
	 * </p>
	 * 
	 * @param id
	 *            {@link java.lang.Long}
	 */
	void delete(Long id);
}
