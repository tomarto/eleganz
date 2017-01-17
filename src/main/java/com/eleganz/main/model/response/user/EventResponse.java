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

	private UserDetailResponse churchUserDetails;
	private UserDetailResponse weddingUserDetails;
	private LocationResponse location;

	/**
	 * <p>
	 * Getter for the field <code>churchUserDetails</code>.
	 * </p>
	 * 
	 * @return the churchUserDetails
	 */
	public UserDetailResponse getChurchUserDetails() {
		return churchUserDetails;
	}

	/**
	 * <p>
	 * Setter for the field <code>churchUserDetails</code>.
	 * </p>
	 * 
	 * @param churchUserDetails
	 *            the churchUserDetails to set
	 */
	public void setChurchUserDetails(UserDetailResponse churchUserDetails) {
		this.churchUserDetails = churchUserDetails;
	}

	/**
	 * <p>
	 * Getter for the field <code>weddingUserDetails</code>.
	 * </p>
	 * 
	 * @return the weddingUserDetails
	 */
	public UserDetailResponse getWeddingUserDetails() {
		return weddingUserDetails;
	}

	/**
	 * <p>
	 * Setter for the field <code>weddingUserDetails</code>.
	 * </p>
	 * 
	 * @param weddingUserDetails
	 *            the weddingUserDetails to set
	 */
	public void setWeddingUserDetails(UserDetailResponse weddingUserDetails) {
		this.weddingUserDetails = weddingUserDetails;
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
