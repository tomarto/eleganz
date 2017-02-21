package com.eleganz.main.service.user;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.eleganz.main.exception.NotFoundException;
import com.eleganz.main.exception.UnauthorizedException;
import com.eleganz.main.facade.authentication.AuthenticationFacade;
import com.eleganz.main.mapper.response.Mapper;
import com.eleganz.main.model.domain.user.User;
import com.eleganz.main.model.request.user.UserCreateRequest;
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
	private final Mapper<User, UserResponse> userResponseMapper;
	private final Mapper<UserCreateRequest, User> userRequestMapper;

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
	 *            a {@link com.eleganz.main.mapper.response.Mapper<User, UserResponse>} object.
	 * @param userRequestMapper
	 *            a {@link com.eleganz.main.mapper.response.Mapper<UserCreateRequest, User>} object.
	 */
	@Autowired
    public UserServiceImpl(AuthenticationFacade authenticationFacade, UserRepository userRepository,
    		Mapper<User, UserResponse> userResponseMapper, Mapper<UserCreateRequest, User> userRequestMapper) {
		this.authenticationFacade = authenticationFacade;
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
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
	public User create(UserCreateRequest request) {
		User newUser = userRequestMapper.convert(request);
		userRepository.save(newUser);

		return newUser;
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
