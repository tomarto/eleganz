package com.eleganz.main.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>
 * UserDetailBase class. Abstract class used for {@link com.eleganz.main.model.domain.user.UserDetail}
 * and {@link com.eleganz.main.model.response.user.UserDetailResponse} objects.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserDetailBase {

	private EventType type;

	/**
	 * <p>
	 * Getter for the field <code>type</code>.
	 * </p>
	 * 
	 * @return the type
	 */
	@JsonIgnore
	public EventType getTypeEnum() {
		return type;
	}

	/**
	 * <p>
	 * Setter for the field <code>type</code>.
	 * </p>
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(EventType type) {
		this.type = type;
	}
}
