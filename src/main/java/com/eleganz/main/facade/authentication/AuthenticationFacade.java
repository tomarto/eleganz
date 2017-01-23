package com.eleganz.main.facade.authentication;

import org.springframework.security.core.Authentication;

import com.eleganz.main.model.domain.user.SecuredUser;

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

    /**
	 * <p>
	 * Retrieves a {@link com.eleganz.main.model.domain.user.SecuredUser} from logged user.
	 * </p>
	 * 
	 * @return a {@link com.eleganz.main.model.domain.user.SecuredUser} object.
	 */
    SecuredUser getSecuredUser();
}
