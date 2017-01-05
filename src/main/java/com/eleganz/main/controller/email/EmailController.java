package com.eleganz.main.controller.email;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleganz.main.model.request.email.EmailRequest;
import com.eleganz.main.model.response.Response;
import com.eleganz.main.service.email.EmailService;
import com.eleganz.main.validator.RequestValidator;

/**
 * <p>
 * EmailController class. Controller used to interact with UI.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
@RequestMapping("/api")
public class EmailController {

	private final EmailService emailService;
	private final RequestValidator requestValidator;

	/**
	 * <p>
	 * Constructor for EmailController.
	 * </p>
	 * 
	 * @param userService
	 *            a {@link com.eleganz.main.service.email.EmailService} object.
	 * @param requestValidator
	 *            a {@link com.eleganz.main.validator.RequestValidator} object.
	 */
	@Autowired
	public EmailController(EmailService emailService, RequestValidator requestValidator) {
		this.emailService = emailService;
		this.requestValidator = requestValidator;
	}

	/**
	 * <p>
	 * Send an email to contact email.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.email.EmailRequest} object.
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@PreAuthorize("permitAll()")
	@RequestMapping(value = "/email", method = POST, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> send(@RequestBody EmailRequest request) {
		requestValidator.validate(request);
		emailService.send(request);

		return new Response<>("Email enviado.");
	}
}
