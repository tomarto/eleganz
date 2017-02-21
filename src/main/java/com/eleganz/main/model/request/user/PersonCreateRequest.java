package com.eleganz.main.model.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.eleganz.main.model.user.PersonBase;
import com.eleganz.main.model.user.PersonType;

/**
 * <p>
 * PersonCreateRequest class. Person request received from client for create.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class PersonCreateRequest extends PersonBase implements Serializable {

	/** Constant <code>serialVersionUID=-1208651286807981117L</code> */
	private static final long serialVersionUID = -1208651286807981117L;

	/**
	 * <p>
	 * Getter for the field <code>firstName</code>.
	 * </p>
	 * 
	 * @return the firstName
	 */
	@NotEmpty
	@Size(min = 3, max = 50)
	@Pattern(regexp = "^[A-z -]*$")
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
	@NotEmpty
	@Size(min = 3, max = 50)
	@Pattern(regexp = "^[A-z -]*$")
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
	@NotNull
	public PersonType getType() {
		return super.getTypeEnum();
	}
}
