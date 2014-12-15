package com.test.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AlbumFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> paraClass) {
		return AlbumFormValidator.class.equals(paraClass);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title is required");
	}

}
