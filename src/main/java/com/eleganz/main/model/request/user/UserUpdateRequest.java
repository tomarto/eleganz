package com.eleganz.main.model.request.user;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.eleganz.main.model.user.UserBase;

/**
 * <p>
 * UserUpdateRequest class. User request received from client for update.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserUpdateRequest extends UserBase implements Serializable {

	/** Constant <code>serialVersionUID=2661651112543559479L</code> */
	private static final long serialVersionUID = 2661651112543559479L;

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
}
