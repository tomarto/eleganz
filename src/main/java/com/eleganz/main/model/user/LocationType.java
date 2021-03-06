package com.eleganz.main.model.user;

/**
 * <p>
 * LocationType enum. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public enum LocationType {

	CHURCH("Iglesia"), EVENT_HALL("Salon de Eventos");

	private String value;

	/**
	 * <p>
	 * Constructor for LocationType.
	 * </p>
	 * 
	 * @param value
	 *            a {@link java.lang.String} object.
	 */
	LocationType(String value) {
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
