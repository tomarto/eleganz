package com.eleganz.main.service.email;

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
}
