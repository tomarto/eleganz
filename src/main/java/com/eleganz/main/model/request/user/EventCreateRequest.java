package com.eleganz.main.model.request.user;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.NotNull;

import com.eleganz.main.model.user.EventBase;
import com.eleganz.main.model.user.EventType;

/**
 * <p>
 * EventCreateRequest class. Event request received from client for create.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class EventCreateRequest extends EventBase implements Serializable {

	/** Constant <code>serialVersionUID=2701209634352115796L</code> */
	private static final long serialVersionUID = 2701209634352115796L;

	private Long id;

	/**
	 * <p>
	 * Getter for the field <code>id</code>.
	 * </p>
	 * 
	 * @return the id
	 */
	@NotNull
	public Long getId() {
		return id;
	}

	/**
	 * <p>
	 * Setter for the field <code>id</code>.
	 * </p>
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Getter for the field <code>date</code>.
	 * </p>
	 * 
	 * @return the date
	 */
//	@NotNull
	public Date getDate() {
		return super.getDate();
	}

	/**
	 * <p>
	 * Getter for the field <code>time</code>.
	 * </p>
	 * 
	 * @return the time
	 */
//	@NotNull
	public Time getTime() {
		return super.getTime();
	}

	/**
	 * <p>
	 * Getter for the field <code>type</code>.
	 * </p>
	 * 
	 * @return the type
	 */
	@NotNull
	public EventType getType() {
		return super.getTypeEnum();
	}
}
