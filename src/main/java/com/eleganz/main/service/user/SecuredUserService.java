package com.eleganz.main.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(
						String.format("User with username: %s not found", username)));
		return new SecuredUser(user);
	}
}
