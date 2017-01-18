package com.eleganz.main.model.response.user;

import com.eleganz.main.model.user.EventBase;

/**
 * <p>
 * EventResponse class. POJO to return as JSON response.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class EventResponse extends EventBase {

	private UserDetailResponse userDetail;
	private LocationResponse location;

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

	/**
	 * <p>
	 * Getter for the field <code>userDetail</code>.
	 * </p>
	 * 
	 * @return the userDetail
	 */
	public UserDetailResponse getUserDetail() {
		return userDetail;
	}

	/**
	 * <p>
	 * Setter for the field <code>userDetail</code>.
	 * </p>
	 * 
	 * @param userDetail
	 *            the userDetail to set
	 */
	public void setUserDetail(UserDetailResponse userDetail) {
		this.userDetail = userDetail;
	}

	/**
	 * <p>
	 * Getter for the field <code>location</code>.
	 * </p>
	 * 
	 * @return the location
	 */
	public LocationResponse getLocation() {
		return location;
	}

	/**
	 * <p>
	 * Setter for the field <code>location</code>.
	 * </p>
	 * 
	 * @param location
	 *            the location to set
	 */
	public void setLocation(LocationResponse location) {
		this.location = location;
	}
}
