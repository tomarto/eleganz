// TODO: DELETE
package com.eleganz.main.command.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.eleganz.main.command.ObservableCommand;

import rx.Observable;

/**
 * <p>
 * TestCommand class.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
@Scope("prototype")
public class TestCommand implements ObservableCommand<String> {

	/** {@inheritDoc} */
	@Override
	public Observable<String> observe() {
		return Observable.just("This is a Test String");
	}
}
