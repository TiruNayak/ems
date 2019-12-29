package com.code.ems.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String>{

	public boolean isValid(String phoneNo, ConstraintValidatorContext arg1) {
		if(phoneNo == null){
			return false;
		}
		//validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) {
        	return true;
        }
        
		return false;
	}



}
