package com.eleganz.main.model.domain.user;

import org.springframework.security.core.authority.AuthorityUtils;

import com.eleganz.main.model.user.Role;

/**
 * <p>
 * SecuredUser class. User used for Spring Security.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class SecuredUser extends org.springframework.security.core.userdetails.User {

	/** Constant <code>serialVersionUID=-7065832480265094617L</code> */
	private static final long serialVersionUID = -7065832480265094617L;

	private User user;

	/**
	 * <p>
	 * Constructor for SecuredUser.
	 * </p>
	 * 
	 * @param user
	 *            a {@link com.eleganz.main.model.domain.user.User} object.
	 */
	public SecuredUser(User user) {
		super(user.getUsername(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}

	/**
	 * <p>
	 * Getter for the field <code>user</code>.
	 * </p>
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * <p>
	 * Getter for the field <code>id</code>.
	 * </p>
	 * 
	 * @return the id
	 */
	public Long getId() {
		return user.getId();
	}

	/**
	 * <p>
	 * Getter for the field <code>role</code>.
	 * </p>
	 * 
	 * @return the role
	 */
	public Role getRole() {
		return user.getRole();
	}
}
