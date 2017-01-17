package com.eleganz.main.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>
 * UserBase class. Abstract class used for {@link com.eleganz.main.model.domain.user.User}
 * and {@link com.eleganz.main.model.response.user.UserResponse} objects.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public abstract class UserBase {

	private Long id;
	private String username;
	private Role role;
	private String email;

	/**
	 * <p>
	 * Getter for the field <code>id</code>.
	 * </p>
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <p>
	 * Setter for the field <code>id</code>.
	 * </p>
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Getter for the field <code>username</code>.
	 * </p>
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <p>
	 * Setter for the field <code>username</code>.
	 * </p>
	 * 
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * <p>
	 * Getter for the field <code>role</code>.
	 * </p>
	 * 
	 * @return the role
	 */
	@JsonIgnore
	public Role getRoleEnum() {
		return role;
	}

	/**
	 * <p>
	 * Setter for the field <code>role</code>.
	 * </p>
	 * 
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * <p>
	 * Getter for the field <code>email</code>.
	 * </p>
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <p>
	 * Setter for the field <code>email</code>.
	 * </p>
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
