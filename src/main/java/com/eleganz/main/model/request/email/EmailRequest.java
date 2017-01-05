package com.eleganz.main.model.request.email;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * EmailRequest class. Email request received from client for sending.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class EmailRequest implements Serializable {

	/** Constant <code>serialVersionUID=-1402857244930834875L</code> */
	private static final long serialVersionUID = -1402857244930834875L;

	@NotEmpty
	@Size(min = 3, max = 60)
	@Pattern(regexp = "^[A-z0-9_. -]*$")
	private String name;

	@NotEmpty
	@Size(min = 9, max = 120)
	@Pattern(regexp = "^[A-z_]+[A-z0-9._-]*[A-z0-9_]+@[A-z]+.[A-z.]{2,5}$")
	private String email;

	@NotEmpty
	@Size(min = 7, max = 18)
	@Pattern(regexp = "^[0-9. -]*")
	private String phone;

	@NotEmpty
	@Size(min = 3, max = 100)
	@Pattern(regexp = "^[A-z0-9_. -]*$")
	private String subject;

	@NotEmpty
	@Size(min = 3, max = 5000)
	private String message;

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

	/**
	 * <p>
	 * Getter for the field <code>phone</code>.
	 * </p>
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * <p>
	 * Setter for the field <code>phone</code>.
	 * </p>
	 * 
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * <p>
	 * Getter for the field <code>subject</code>.
	 * </p>
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * <p>
	 * Setter for the field <code>subject</code>.
	 * </p>
	 * 
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * <p>
	 * Getter for the field <code>message</code>.
	 * </p>
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <p>
	 * Setter for the field <code>message</code>.
	 * </p>
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
