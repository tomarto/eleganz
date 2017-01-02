package com.eleganz.main.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.request.user.UserCreateRequest;
import com.eleganz.main.repository.user.UserRepository;

/**
 * <p>
 * UserServiceImpl class. UserService implementation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	/**
	 * <p>
	 * Constructor for UserServiceImpl.
	 * </p>
	 * 
	 * @param userRepository
	 *            a {@link com.eleganz.main.repository.user.UserRepository} object.
	 */
	@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	/** {@inheritDoc} */
	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("username"));
	}

	/** {@inheritDoc} */
	@Override
	public Optional<User> getUserById(long id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	/** {@inheritDoc} */
	@Override
	public Optional<User> getUserByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}

	/** {@inheritDoc} */
	@Override
	public User create(UserCreateRequest request) {
		final User user = new User();
		user.setUsername(request.getUsername());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(request.getPassword()));
		user.setRole(request.getRole());
		return userRepository.save(user);
	}
}
