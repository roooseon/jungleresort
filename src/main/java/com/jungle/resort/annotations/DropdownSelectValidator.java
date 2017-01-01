package com.jungle.resort.annotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DropdownSelectValidator implements ConstraintValidator<DropdownSelect, String>{

	private static final Set<String> ACCEPTED_VALUES = new HashSet<String>(
            Arrays.asList(
                    "Available",
                    "Rented",
                    "Booked"
            )
    );
	
	@Override
	public void initialize(DropdownSelect constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String selectDropdown, ConstraintValidatorContext context) {
		return ACCEPTED_VALUES.contains(selectDropdown);
	}

}
