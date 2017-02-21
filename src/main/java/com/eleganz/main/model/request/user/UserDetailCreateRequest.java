package com.eleganz.main.model.request.user;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.eleganz.main.model.user.UserDetailBase;
import com.eleganz.main.model.user.UserType;

/**
 * <p>
 * UserDetailCreateRequest class. User detail request received from client for creation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserDetailCreateRequest extends UserDetailBase implements Serializable {

	/** Constant <code>serialVersionUID=4174267938718085479L</code> */
	private static final long serialVersionUID = 4174267938718085479L;

	private Set<PersonCreateRequest> people;
	private Set<EventCreateRequest> events;

	/**
	 * <p>
	 * Getter for the field <code>type</code>.
	 * </p>
	 * 
	 * @return the type
	 */
	@NotNull
	public UserType getType() {
		return super.getTypeEnum();
	}

	/**
	 * <p>
	 * Getter for the field <code>people</code>.
	 * </p>
	 * 
	 * @return the people
	 */
	@NotNull
	public Set<PersonCreateRequest> getPeople() {
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
	public void setPeople(Set<PersonCreateRequest> people) {
		this.people = people;
	}

	/**
	 * <p>
	 * Getter for the field <code>events</code>.
	 * </p>
	 * 
	 * @return the events
	 */
	@NotNull
	public Set<EventCreateRequest> getEvents() {
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
	public void setEvents(Set<EventCreateRequest> events) {
		this.events = events;
	}
}
