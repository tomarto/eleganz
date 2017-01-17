package com.eleganz.main.model.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eleganz.main.model.user.LocationBase;
import com.eleganz.main.model.user.LocationType;

/**
 * <p>
 * Location class. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Entity
@Table(name = "Location")
public class Location extends LocationBase {

	private Set<Event> events;

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
		return super.getId();
	}

	/**
	 * <p>
	 * Getter for the field <code>name</code>.
	 * </p>
	 * 
	 * @return the name
	 */
	@Column(nullable = false)
	public String getName() {
		return super.getName();
	}

	/**
	 * <p>
	 * Getter for the field <code>address</code>.
	 * </p>
	 * 
	 * @return the address
	 */
	@Column(nullable = false)
	public String getAddress() {
		return super.getAddress();
	}

	/**
	 * <p>
	 * Getter for the field <code>city</code>.
	 * </p>
	 * 
	 * @return the city
	 */
	@Column(nullable = false)
	public String getCity() {
		return super.getCity();
	}

	/**
	 * <p>
	 * Getter for the field <code>state</code>.
	 * </p>
	 * 
	 * @return the state
	 */
	@Column(nullable = false)
	public String getState() {
		return super.getState();
	}

	/**
	 * <p>
	 * Getter for the field <code>country</code>.
	 * </p>
	 * 
	 * @return the country
	 */
	@Column(nullable = false)
	public String getCountry() {
		return super.getCountry();
	}

	/**
	 * <p>
	 * Getter for the field <code>postalCode</code>.
	 * </p>
	 * 
	 * @return the postalCode
	 */
	@Column(name = "postal_code", nullable = false)
	public String getPostalCode() {
		return super.getPostalCode();
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
	public LocationType getType() {
		return super.getTypeEnum();
	}

	/**
	 * <p>
	 * Getter for the field <code>events</code>.
	 * </p>
	 * 
	 * @return the events
	 */
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	public Set<Event> getEvents() {
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
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
