package com.eleganz.main.model.user;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>
 * EventBase class. Abstract class used for {@link com.eleganz.main.model.domain.user.Event}
 * and {@link com.eleganz.main.model.response.user.EventResponse} objects.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class EventBase {

	private Date date;
	private Time time;
	private EventType type;

	/**
	 * <p>
	 * Getter for the field <code>date</code>.
	 * </p>
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <p>
	 * Setter for the field <code>date</code>.
	 * </p>
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * <p>
	 * Getter for the field <code>time</code>.
	 * </p>
	 * 
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * <p>
	 * Setter for the field <code>time</code>.
	 * </p>
	 * 
	 * @param time
	 *            the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}

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
