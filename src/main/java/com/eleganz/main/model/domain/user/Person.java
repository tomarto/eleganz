package com.eleganz.main.model.domain.user;

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

import com.eleganz.main.model.user.PersonBase;
import com.eleganz.main.model.user.PersonType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>
 * Person class. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Entity
@Table(name = "Person")
public class Person extends PersonBase {

	private Long id;
	private UserDetail userDetail;

	/**
	 * <p>
	 * Getter for the field <code>id</code>.
	 * </p>
	 * 
	 * @return the id
	 */
	@JsonIgnore
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
	 * Getter for the field <code>firstName</code>.
	 * </p>
	 * 
	 * @return the firstName
	 */
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return super.getFirstName();
	}

	/**
	 * <p>
	 * Getter for the field <code>lastName</code>.
	 * </p>
	 * 
	 * @return the lastName
	 */
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return super.getLastName();
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
	public PersonType getType() {
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
}
