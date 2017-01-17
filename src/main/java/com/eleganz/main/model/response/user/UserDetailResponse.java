package com.eleganz.main.model.response.user;

import com.eleganz.main.model.user.UserDetailBase;

/**
 * <p>
 * UserDetailResponse class. POJO to return as JSON response.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserDetailResponse extends UserDetailBase {

	private UserResponse user;
	private PersonResponse bride;
	private PersonResponse groom;
	private EventResponse churchEvent;
	private EventResponse weddingEvent;

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
	 * Getter for the field <code>user</code>.
	 * </p>
	 * 
	 * @return the user
	 */
	public UserResponse getUser() {
		return user;
	}

	/**
	 * <p>
	 * Setter for the field <code>user</code>.
	 * </p>
	 * 
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserResponse user) {
		this.user = user;
	}

	/**
	 * <p>
	 * Getter for the field <code>bride</code>.
	 * </p>
	 * 
	 * @return the bride
	 */
	public PersonResponse getBride() {
		return bride;
	}

	/**
	 * <p>
	 * Setter for the field <code>bride</code>.
	 * </p>
	 * 
	 * @param bride
	 *            the bride to set
	 */
	public void setBride(PersonResponse bride) {
		this.bride = bride;
	}

	/**
	 * <p>
	 * Getter for the field <code>groom</code>.
	 * </p>
	 * 
	 * @return the groom
	 */
	public PersonResponse getGroom() {
		return groom;
	}

	/**
	 * <p>
	 * Setter for the field <code>groom</code>.
	 * </p>
	 * 
	 * @param groom
	 *            the groom to set
	 */
	public void setGroom(PersonResponse groom) {
		this.groom = groom;
	}

	/**
	 * <p>
	 * Getter for the field <code>churchEvent</code>.
	 * </p>
	 * 
	 * @return the churchEvent
	 */
	public EventResponse getChurchEvent() {
		return churchEvent;
	}

	/**
	 * <p>
	 * Setter for the field <code>churchEvent</code>.
	 * </p>
	 * 
	 * @param churchEvent
	 *            the churchEvent to set
	 */
	public void setChurchEvent(EventResponse churchEvent) {
		this.churchEvent = churchEvent;
	}

	/**
	 * <p>
	 * Getter for the field <code>weddingEvent</code>.
	 * </p>
	 * 
	 * @return the weddingEvent
	 */
	public EventResponse getWeddingEvent() {
		return weddingEvent;
	}

	/**
	 * <p>
	 * Setter for the field <code>weddingEvent</code>.
	 * </p>
	 * 
	 * @param weddingEvent
	 *            the weddingEvent to set
	 */
	public void setWeddingEvent(EventResponse weddingEvent) {
		this.weddingEvent = weddingEvent;
	}
}
