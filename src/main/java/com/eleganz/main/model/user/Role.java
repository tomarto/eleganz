package com.eleganz.main.model.user;

/**
 * <p>
 * Role enum. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public enum Role {
	ROLE_ADMIN("Admin"), ROLE_USER("User");

	private String value;

	/**
	 * <p>
	 * Constructor for EventType.
	 * </p>
	 * 
	 * @param value
	 *            a {@link java.lang.String} object.
	 */
	Role(String value) {
		this.value = value;
	}

	/**
	 * <p>
	 * Getter for the field <code>value</code>.
	 * </p>
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
