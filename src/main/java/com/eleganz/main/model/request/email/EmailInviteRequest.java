package com.eleganz.main.model.request.email;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * EmailInviteRequest class. Email request received from client for sending.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class EmailInviteRequest implements Serializable {

	/** Constant <code>serialVersionUID=2715560622561138360L</code> */
	private static final long serialVersionUID = 2715560622561138360L;

	@NotEmpty
	@Size(min = 3, max = 60)
	@Pattern(regexp = "^[A-z0-9_. -]*$")
	private String name;

	@NotEmpty
	@Size(min = 9, max = 120)
	@Pattern(regexp = "^[A-z_]+[A-z0-9._-]*[A-z0-9_]+@[A-z]+.[A-z.]{2,5}$")
	private String email;

	/**
	 * <p>
	 * Getter for the field <code>name</code>.
	 * </p>
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>
	 * Setter for the field <code>name</code>.
	 * </p>
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
