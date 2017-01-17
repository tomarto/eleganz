package com.eleganz.main.model.user;

/**
 * <p>
 * EventType enum. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public enum EventType {

	WEDDING("Wedding");

	private String value;

	/**
	 * <p>
	 * Constructor for EventType.
	 * </p>
	 * 
	 * @param value
	 *            a {@link java.lang.String} object.
	 */
	EventType(String value) {
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
