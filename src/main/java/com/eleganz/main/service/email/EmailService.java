package com.eleganz.main.service.email;

import java.util.List;

import com.eleganz.main.model.request.email.EmailInviteRequest;
import com.eleganz.main.model.request.email.EmailRequest;

/**
 * <p>
 * EmailService interface. Service used for email actions.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface EmailService {

	/**
	 * <p>
	 * Send an email to contact email.
	 * </p>
	 * 
	 * @param request
	 *            {@link com.eleganz.main.model.request.email.EmailRequest}
	 */
	void send(EmailRequest request);

	/**
	 * <p>
	 * Send an email to invites.
	 * </p>
	 * 
	 * @param request
	 *            {@link java.util.List<EmailInviteRequest>}
	 */
	void sendInvites(List<EmailInviteRequest> request);
}
