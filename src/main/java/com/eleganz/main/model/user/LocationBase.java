package com.eleganz.main.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>
 * LocationBase class. Abstract class used for {@link com.eleganz.main.model.domain.user.Location}
 * and {@link com.eleganz.main.model.response.user.LocationResponse} objects.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class LocationBase {

	private Long id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private LocationType type;

	/**
	 * <p>
	 * Getter for the field <code>id</code>.
	 * </p>
	 * 
	 * @return the id
	 */
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
	 * Getter for the field <code>name</code>.
	 * </p>
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>
	 * Setter for the field <code>name</code>.
	 * </p>
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>
	 * Getter for the field <code>address</code>.
	 * </p>
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <p>
	 * Setter for the field <code>address</code>.
	 * </p>
	 * 
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * <p>
	 * Getter for the field <code>city</code>.
	 * </p>
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <p>
	 * Setter for the field <code>city</code>.
	 * </p>
	 * 
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * <p>
	 * Getter for the field <code>state</code>.
	 * </p>
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * <p>
	 * Setter for the field <code>state</code>.
	 * </p>
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * <p>
	 * Getter for the field <code>country</code>.
	 * </p>
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * <p>
	 * Setter for the field <code>country</code>.
	 * </p>
	 * 
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * <p>
	 * Getter for the field <code>postalCode</code>.
	 * </p>
	 * 
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * <p>
	 * Setter for the field <code>postalCode</code>.
	 * </p>
	 * 
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * <p>
	 * Getter for the field <code>type</code>.
	 * </p>
	 * 
	 * @return the type
	 */
	@JsonIgnore
	public LocationType getTypeEnum() {
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
	public void setType(LocationType type) {
		this.type = type;
	}
}
