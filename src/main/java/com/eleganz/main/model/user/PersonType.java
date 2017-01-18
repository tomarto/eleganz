package com.eleganz.main.model.user;

/**
 * <p>
 * PersonType enum. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public enum PersonType {

	BRIDE("Novia"), GROOM("Novio");

	private String value;

	/**
	 * <p>
	 * Constructor for PersonType.
	 * </p>
	 * 
	 * @param value
	 *            a {@link java.lang.String} object.
	 */
	PersonType(String value) {
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
