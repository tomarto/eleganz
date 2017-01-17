package com.eleganz.main.model.response.user;

import java.util.Set;

import com.eleganz.main.model.user.LocationBase;

/**
 * <p>
 * LocationResponse class. POJO to return as JSON response.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class LocationResponse extends LocationBase {

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
