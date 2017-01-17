package com.eleganz.main.model.domain.user;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eleganz.main.model.user.EventBase;

/**
 * <p>
 * Person class. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Entity
@Table(name = "Event")
public class Event extends EventBase {

	private Long id;
	private UserDetail churchUserDetails;
	private UserDetail weddingUserDetails;
	private Location location;

	/**
	 * <p>
	 * Getter for the field <code>id</code>.
	 * </p>
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "the_date")
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
	@Column(name = "the_time")
	public Time getTime() {
		return super.getTime();
	}

	/**
	 * <p>
	 * Getter for the field <code>churchUserDetails</code>.
	 * </p>
	 * 
	 * @return the churchUserDetails
	 */
	@OneToOne(mappedBy = "churchEvent")
	public UserDetail getChurchUserDetails() {
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
	public void setChurchUserDetails(UserDetail churchUserDetails) {
		this.churchUserDetails = churchUserDetails;
	}

	/**
	 * <p>
	 * Getter for the field <code>weddingUserDetails</code>.
	 * </p>
	 * 
	 * @return the weddingUserDetails
	 */
	@OneToOne(mappedBy = "weddingEvent")
	public UserDetail getWeddingUserDetails() {
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
	public void setWeddingUserDetails(UserDetail weddingUserDetails) {
		this.weddingUserDetails = weddingUserDetails;
	}

	/**
	 * <p>
	 * Getter for the field <code>location</code>.
	 * </p>
	 * 
	 * @return the location
	 */
	@ManyToOne
	@JoinColumn(name = "location_id")
	public Location getLocation() {
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
	public void setLocation(Location location) {
		this.location = location;
	}
}
