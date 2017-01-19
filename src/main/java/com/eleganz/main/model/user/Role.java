package com.eleganz.main.model.user;

/**
 * <p>
 * Role enum. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public enum Role {

	ROLE_ADMIN("Administrador"), ROLE_USER("Usuario");

	private String value;

	/**
	 * <p>
	 * Constructor for Role.
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
