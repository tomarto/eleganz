package com.eleganz.main.model.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eleganz.main.model.user.EventType;
import com.eleganz.main.model.user.UserDetailBase;

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
	private Person bride;
	private Person groom;
	private Event churchEvent;
	private Event weddingEvent;

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
	public EventType getType() {
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
	 * Getter for the field <code>bride</code>.
	 * </p>
	 * 
	 * @return the bride
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bride_id")
	public Person getBride() {
		return bride;
	}

	/**
	 * <p>
	 * Setter for the field <code>bride</code>.
	 * </p>
	 * 
	 * @param bride
	 *            the bride to set
	 */
	public void setBride(Person bride) {
		this.bride = bride;
	}

	/**
	 * <p>
	 * Getter for the field <code>groom</code>.
	 * </p>
	 * 
	 * @return the groom
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "groom_id")
	public Person getGroom() {
		return groom;
	}

	/**
	 * <p>
	 * Setter for the field <code>groom</code>.
	 * </p>
	 * 
	 * @param groom
	 *            the groom to set
	 */
	public void setGroom(Person groom) {
		this.groom = groom;
	}

	/**
	 * <p>
	 * Getter for the field <code>churchEvent</code>.
	 * </p>
	 * 
	 * @return the churchEvent
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "church_event_id")
	public Event getChurchEvent() {
		return churchEvent;
	}

	/**
	 * <p>
	 * Setter for the field <code>churchEvent</code>.
	 * </p>
	 * 
	 * @param churchEvent
	 *            the churchEvent to set
	 */
	public void setChurchEvent(Event churchEvent) {
		this.churchEvent = churchEvent;
	}

	/**
	 * <p>
	 * Getter for the field <code>weddingEvent</code>.
	 * </p>
	 * 
	 * @return the weddingEvent
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "wedding_event_id")
	public Event getWeddingEvent() {
		return weddingEvent;
	}

	/**
	 * <p>
	 * Setter for the field <code>weddingEvent</code>.
	 * </p>
	 * 
	 * @param weddingEvent
	 *            the weddingEvent to set
	 */
	public void setWeddingEvent(Event weddingEvent) {
		this.weddingEvent = weddingEvent;
	}
}
