package com.eleganz.main.model.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eleganz.main.model.user.UserDetailBase;
import com.eleganz.main.model.user.UserType;

/**
 * <p>
 * UserDetail class. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Entity
@Table(name = "UserDetail")
public class UserDetail extends UserDetailBase {

	private Long id;
	private User user;
	private Set<Person> people;
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
	 * Getter for the field <code>type</code>.
	 * </p>
	 * 
	 * @return the type
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public UserType getType() {
		return super.getTypeEnum();
	}

	/**
	 * <p>
	 * Getter for the field <code>user</code>.
	 * </p>
	 * 
	 * @return the user
	 */
	@OneToOne(mappedBy = "userDetail")
	public User getUser() {
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
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * <p>
	 * Getter for the field <code>people</code>.
	 * </p>
	 * 
	 * @return the people
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userDetail", cascade = CascadeType.ALL)
	public Set<Person> getPeople() {
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
	public void setPeople(Set<Person> people) {
		this.people = people;
	}

	/**
	 * <p>
	 * Getter for the field <code>events</code>.
	 * </p>
	 * 
	 * @return the events
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userDetail", cascade = CascadeType.ALL)
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
