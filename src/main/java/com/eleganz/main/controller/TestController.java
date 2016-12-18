//TODO: DELETE
package com.eleganz.main.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleganz.main.command.test.TestCommandFactory;
import com.eleganz.main.model.response.Response;

/**
 * <p>
 * TestController class. Controller for testing purposes.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
public class TestController {

	private TestCommandFactory factory;

	/**
	 * <p>
	 * Constructor for UserController.
	 * </p>
	 * 
	 * @param factory
	 *            a {@link import com.eleganz.main.command.test.TestCommandFactory} object.
	 */
	@Autowired
	public TestController(TestCommandFactory factory) {
		this.factory = factory;
	}

	/**
	 * <p>
	 * Retrieves a single User.
	 * </p>
	 * 
	 * @return a {@link com.eleganz.main.model.response.Response<String>} object.
	 */
	@RequestMapping(value = "/helpdesk", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> test() {
		return new Response<>(factory.createTestCommand().observe().toBlocking().single());
	}
}
