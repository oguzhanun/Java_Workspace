package com.oguzhanun.springdemo.mvc.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private boolean result;
	private String checkValue;
	
	@Override
	public void initialize(CourseCode courseCode) {
		
		checkValue = courseCode.value();
	}

	@Override
	public boolean isValid(String enteredValue, ConstraintValidatorContext arg1) {
		
		if(enteredValue != null) {
		
			result = enteredValue.startsWith(checkValue);
		
		} else result = true;
		
		return result;
	}

}
