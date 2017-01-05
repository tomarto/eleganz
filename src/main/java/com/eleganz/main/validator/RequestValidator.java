package com.eleganz.main.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.eleganz.main.exception.BadRequestException;

/**
 * <p>
 * RequestValidator class.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component("requestValidator")
public class RequestValidator {

	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	/**
	 * <p>
	 * Verifies if request contains a violation.
	 * </p>
	 * 
	 * @param request
	 *            a {@link java.lang.Object} object.
	 */
	public void validate(Object target) {
		Set<ConstraintViolation<Object>> violations = factory.getValidator().validate(target);
		if(!violations.isEmpty()) {
			throw new BadRequestException("Petición inválida. Intente de nuevo.");
		}
	}
}
