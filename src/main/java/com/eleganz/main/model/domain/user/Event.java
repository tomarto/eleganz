package com.eleganz.main.model.domain.user;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eleganz.main.model.user.EventBase;
import com.eleganz.main.model.user.EventType;

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
	private UserDetail userDetail;
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
	 * Getter for the field <code>type</code>.
	 * </p>
	 * 
	 * @return the type
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public EventType getType() {
		return super.getTypeEnum();
	}

	/**
	 * <p>
	 * Getter for the field <code>userDetail</code>.
	 * </p>
	 * 
	 * @return the userDetail
	 */
	@ManyToOne
	@JoinColumn(name = "user_detail_id")
	public UserDetail getUserDetail() {
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
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
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
