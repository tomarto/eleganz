package com.eleganz.main.model.response.user;

import java.util.Set;

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
	private Set<PersonResponse> people;
	private Set<EventResponse> events;

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
	 * Getter for the field <code>people</code>.
	 * </p>
	 * 
	 * @return the people
	 */
	public Set<PersonResponse> getPeople() {
		return people;
	}

	/**
	 * <p>
	 * Setter for the field <code>people</code>.
	 * </p>
	 * 
	 * @param people
	 *            the people to set
	 */
	public void setPeople(Set<PersonResponse> people) {
		this.people = people;
	}

	/**
	 * <p>
	 * Getter for the field <code>events</code>.
	 * </p>
	 * 
	 * @return the events
	 */
	public Set<EventResponse> getEvents() {
		return events;
	}

	/**
	 * <p>
	 * Setter for the field <code>events</code>.
	 * </p>
	 * 
	 * @param events
	 *            the events to set
	 */
	public void setEvents(Set<EventResponse> events) {
		this.events = events;
	}
}
