package com.eleganz.main.model.response.user;

import com.eleganz.main.model.user.UserBase;

/**
 * <p>
 * UserResponse class. POJO to return as JSON response.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public class UserResponse extends UserBase {

	private UserDetailResponse userDetail;

	/**
	 * <p>
	 * Getter for the field <code>role</code>.
	 * </p>
	 * 
	 * @return the role
	 */
	public String getType() {
		return super.getRoleEnum() == null ? null : super.getRoleEnum().getValue();
	}

	/**
	 * <p>
	 * Getter for the field <code>userDetail</code>.
	 * </p>
	 * 
	 * @return the userDetail
	 */
	public UserDetailResponse getUserDetail() {
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
	public void setUserDetail(UserDetailResponse userDetail) {
		this.userDetail = userDetail;
	}
}
