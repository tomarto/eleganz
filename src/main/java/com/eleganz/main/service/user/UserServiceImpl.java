package com.eleganz.main.service.user;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eleganz.main.exception.NotFoundException;
import com.eleganz.main.exception.UnauthorizedException;
import com.eleganz.main.facade.authentication.AuthenticationFacade;
import com.eleganz.main.mapper.response.ResponseMapper;
import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.request.user.UserRequest;
import com.eleganz.main.model.request.user.UserUpdateRequest;
import com.eleganz.main.model.response.user.UserResponse;
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

	private final AuthenticationFacade authenticationFacade;
	private final UserRepository userRepository;
	private final ResponseMapper<User, UserResponse> userResponseMapper;

	/**
	 * <p>
	 * Constructor for UserServiceImpl.
	 * </p>
	 * 
	 * @param authenticationFacade
	 *            a {@link com.eleganz.main.facade.authentication.AuthenticationFacade} object.
	 * @param userRepository
	 *            a {@link com.eleganz.main.repository.user.UserRepository} object.
	 * @param userResponseMapper
	 *            a {@link com.eleganz.main.mapper.response.ResponseMapper<User, UserResponse>} object.
	 */
	@Autowired
    public UserServiceImpl(AuthenticationFacade authenticationFacade, UserRepository userRepository,
    		ResponseMapper<User, UserResponse> userResponseMapper) {
		this.authenticationFacade = authenticationFacade;
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
    }

	/** {@inheritDoc} */
	@Override
	public Collection<UserResponse> getAllUsers() {
		return userRepository.findAll(new Sort("username")).stream()
				.map(user -> userResponseMapper.convert(user))
				.collect(Collectors.toList());
	}

	/** {@inheritDoc} */
	@Override
	public Optional<UserResponse> getUserById(long id) {
		return Optional.ofNullable(userResponseMapper.convert(userRepository.findOne(id)));
	}

	/** {@inheritDoc} */
	@Override
	public Optional<User> getUserByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}

	/** {@inheritDoc} */
	@Override
	public UserResponse create(UserRequest request) {
		final User user = new User();
		user.setUsername(request.getUsername());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(request.getPassword()));
		user.setRole(request.getRole());
		return userResponseMapper.convert(userRepository.save(user));
	}

	/** {@inheritDoc} */
	@Override
	public void update(Long id, UserUpdateRequest request) {
		final User user = Optional.ofNullable(userRepository.findOne(id))
				.orElseThrow(() -> new NotFoundException(
						String.format("No se encontró al Usuario: %s", request.getUsername())));
		user.setEmail(request.getEmail());
		userRepository.save(user);
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Long id) {
		final User user = Optional.ofNullable(userRepository.findOne(id))
				.orElseThrow(() -> new NotFoundException(
						String.format("No se encontró al Usuario")));
		if(authenticationFacade.getSecuredUser().getUsername().equals(user.getUsername())) {
			throw new UnauthorizedException(
					String.format("No tienes permiso para eliminar al Usuario: %s", user.getUsername()));
		}
		userRepository.delete(id);
	}
}
