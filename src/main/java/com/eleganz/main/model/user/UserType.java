package com.eleganz.main.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * UserType enum. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserType {

	WEDDING("Boda");

	private String value;

	/**
	 * <p>
	 * Constructor for UserType.
	 * </p>
	 * 
	 * @param value
	 *            a {@link java.lang.String} object.
	 */
	UserType(String value) {
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
