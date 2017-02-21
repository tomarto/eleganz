package com.eleganz.main.model.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.eleganz.main.model.user.Role;
import com.eleganz.main.model.user.UserBase;

/**
 * <p>
 * UserCreateRequest class. User request received from client for create.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserCreateRequest extends UserBase implements Serializable {

	/** Constant <code>serialVersionUID=8667707945986237001L</code> */
	private static final long serialVersionUID = 8667707945986237001L;

	private UserDetailCreateRequest detail;

	/**
	 * <p>
	 * Getter for the field <code>email</code>.
	 * </p>
	 * 
	 * @return the email
	 */
	@NotEmpty
	@Size(min = 6, max = 254)
	@Pattern(regexp = "^[A-z_]+[A-z0-9._-]*[A-z0-9_]+@[A-z]+.[A-z.]{2,5}$")
	public String getEmail() {
		return super.getEmail();
	}

	/**
	 * <p>
	 * Getter for the field <code>role</code>.
	 * </p>
	 * 
	 * @return the role
	 */
	@NotNull
	public Role getType() {
		return super.getRoleEnum();
	}

	/**
	 * <p>
	 * Setter for the field <code>role</code>.
	 * </p>
	 * 
	 * @param role
	 *            the role to set
	 */
	public void setType(Role type) {
		super.setRole(type);
	}

	/**
	 * <p>
	 * Getter for the field <code>detail</code>.
	 * </p>
	 * 
	 * @return the detail
	 */
	@NotNull
	public UserDetailCreateRequest getDetail() {
		return detail;
	}

	/**
	 * <p>
	 * Setter for the field <code>detail</code>.
	 * </p>
	 * 
	 * @param detail
	 *            the detail to set
	 */
	public void setDetail(UserDetailCreateRequest detail) {
		this.detail = detail;
	}
}
