// TODO: DELETE
package com.eleganz.main.command.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleganz.main.command.ObservableCommand;

/**
 * <p>
 * TestCommandFactory class.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
public class TestCommandFactory {

	private TestCommand testCommand;

	/**
	 * <p>
	 * Constructor for TestCommandFactory.
	 * </p>
	 * 
	 * @param testCommand
	 *            a {@link com.eleganz.main.command.test.TestCommand} object.
	 */
	@Autowired
	public TestCommandFactory(TestCommand testCommand) {
		this.testCommand = testCommand;
	}

	/**
	 * <p>
	 * Creates a new ObservableCommand for Testing purposes.
	 * </p>
	 *            
	 * @return an {@link com.eleganz.main.command.ObservableCommand<String>} object.
	 */
	public ObservableCommand<String> createTestCommand() {
		return testCommand;
	}
}
