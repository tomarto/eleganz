package com.eleganz.main.model.response.user;

import com.eleganz.main.model.user.PersonBase;

/**
 * <p>
 * PersonResponse class. POJO to return as JSON response.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class PersonResponse extends PersonBase {

	/**
	 * <p>
	 * Getter for the field <code>type</code>.
	 * </p>
	 * 
	 * @return the type
	 */
	public String getType() {
		return super.getTypeEnum() == null ? null : super.getTypeEnum().getValue();
	}
}
