package com.eleganz.main.model.request.user;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.eleganz.main.model.user.Role;

/**
 * <p>
 * UserRequest class. User request received from client for creation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserRequest implements Serializable {

	/** Constant <code>serialVersionUID=-9077759529079281285L</code> */
	private static final long serialVersionUID = -9077759529079281285L;

	@NotEmpty
	@Size(min = 5, max = 50)
	@Pattern(regexp = "^[A-z0-9_. -]*$")
	private String username;

	@NotEmpty
	@Size(min = 6, max = 50)
	@Pattern(regexp = "^[A-z0-9_. -]*$")
	private String password;

	@NotEmpty
	@Size(min = 6, max = 50)
	@Pattern(regexp = "^[A-z0-9_. -]*$")
	private String passwordRepeat;

	@NotEmpty
	private Role role;

	@Size(min = 6, max = 254)
	@Pattern(regexp = "^[A-z_]+[A-z0-9._-]*[A-z0-9_]+@[A-z]+.[A-z.]{2,5}$")
	private String email;

	private UserDetailRequest userDetail;

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
	 * Getter for the field <code>password</code>.
	 * </p>
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <p>
	 * Setter for the field <code>password</code>.
	 * </p>
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * <p>
	 * Getter for the field <code>passwordRepeat</code>.
	 * </p>
	 * 
	 * @return the passwordRepeat
	 */
	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	/**
	 * <p>
	 * Setter for the field <code>passwordRepeat</code>.
	 * </p>
	 * 
	 * @param passwordRepeat
	 *            the passwordRepeat to set
	 */
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	/**
	 * <p>
	 * Getter for the field <code>role</code>.
	 * </p>
	 * 
	 * @return the role
	 */
	public Role getRole() {
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

	/**
	 * <p>
	 * Getter for the field <code>userDetail</code>.
	 * </p>
	 * 
	 * @return the userDetail
	 */
	public UserDetailRequest getUserDetail() {
		return userDetail;
	}

	/**
	 * <p>
	 * Setter for the field <code>userDetail</code>.
	 * </p>
	 * 
	 * @param userDetail
	 *            the userDetail to set
	 */
	public void setUserDetail(UserDetailRequest userDetail) {
		this.userDetail = userDetail;
	}
}
