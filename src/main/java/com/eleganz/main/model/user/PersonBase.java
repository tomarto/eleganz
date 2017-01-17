package com.eleganz.main.model.user;

/**
 * <p>
 * PersonBase class. Abstract class used for {@link com.eleganz.main.model.domain.user.Person}
 * and {@link com.eleganz.main.model.response.user.PersonResponse} objects.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class PersonBase {

	private String firstName;
	private String lastName;

	/**
	 * <p>
	 * Getter for the field <code>firstName</code>.
	 * </p>
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <p>
	 * Setter for the field <code>firstName</code>.
	 * </p>
	 * 
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * <p>
	 * Getter for the field <code>lastName</code>.
	 * </p>
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * <p>
	 * Setter for the field <code>lastName</code>.
	 * </p>
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
