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

import com.eleganz.main.model.user.Role;
import com.eleganz.main.model.user.UserBase;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>
 * User class. Domain linked to database.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Entity
@Table(name = "User")
public class User extends UserBase {

	private String passwordHash;
	private UserDetail userDetail;

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
	 * Getter for the field <code>username</code>.
	 * </p>
	 * 
	 * @return the username
	 */
	@Column(nullable = false, unique = true)
	public String getUsername() {
		return super.getUsername();
	}

	/**
	 * <p>
	 * Getter for the field <code>passwordHash</code>.
	 * </p>
	 * 
	 * @return the passwordHash
	 */
	@JsonIgnore
	@Column(name = "password_hash", nullable = false)
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * <p>
	 * Setter for the field <code>passwordHash</code>.
	 * </p>
	 * 
	 * @param passwordHash
	 *            the passwordHash to set
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * <p>
	 * Getter for the field <code>role</code>.
	 * </p>
	 * 
	 * @return the role
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public Role getRole() {
		return super.getRoleEnum();
	}

	/**
	 * <p>
	 * Getter for the field <code>email</code>.
	 * </p>
	 * 
	 * @return the email
	 */
	@Column(nullable = false)
	public String getEmail() {
		return super.getEmail();
	}

	/**
	 * <p>
	 * Getter for the field <code>userDetail</code>.
	 * </p>
	 * 
	 * @return the userDetail
	 */
	@OneToOne(cascade = CascadeType.ALL)
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
