package com.eleganz.main.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.eleganz.main.exception.NotFoundException;
import com.eleganz.main.model.domain.user.SecuredUser;
import com.eleganz.main.model.domain.user.User;

/**
 * <p>
 * SecuredUserService class. Service used it to map it to SecuredUser.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
public class SecuredUserService implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public SecuredUserService(UserService userService) {
		this.userService = userService;
	}

	/** {@inheritDoc} */
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userService.getUserByUsername(username)
				.orElseThrow(() -> new NotFoundException(
						String.format("No se encontró al usuario %s", username)));
		return new SecuredUser(user);
	}
}
