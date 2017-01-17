package com.eleganz.main.model.request.user;

import java.io.Serializable;

import com.eleganz.main.model.user.EventType;

/**
 * <p>
 * UserDetailRequest class. User request received from client for creation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserDetailRequest implements Serializable {

	/** Constant <code>serialVersionUID=4171766686461276203L</code> */
	private static final long serialVersionUID = 4171766686461276203L;

	private EventType type;

	/**
	 * <p>
	 * Getter for the field <code>type</code>.
	 * </p>
	 * 
	 * @return the type
	 */
	public EventType getType() {
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
