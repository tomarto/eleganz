package com.eleganz.main.facade.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.eleganz.main.model.domain.user.SecuredUser;

/**
 * <p>
 * AuthenticationFacadeImpl class. AuthenticationFacade implementation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component
public class AuthenticationFacadeImpl implements AuthenticationFacade {

	/** {@inheritDoc} */
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /** {@inheritDoc} */
    @Override
    public SecuredUser getSecuredUser() {
    	return (SecuredUser) getAuthentication().getPrincipal();
    }
}
