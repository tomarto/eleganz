package com.eleganz.main.facade.authentication;

import org.springframework.security.core.Authentication;

/**
 * <p>
 * AuthenticationFacade interface. Facade used to retrieve the authentication everywhere.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface AuthenticationFacade {

	/**
	 * <p>
	 * Retrieves a {@link org.springframework.security.core.Authentication} from logged user.
	 * </p>
	 * 
	 * @return a {@link org.springframework.security.core.Authentication} object.
	 */
    Authentication getAuthentication();
}
