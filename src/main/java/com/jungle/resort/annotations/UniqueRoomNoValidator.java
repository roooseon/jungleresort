package com.jungle.resort.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jungle.resort.repositories.RoomDAO;

public class UniqueRoomNoValidator implements ConstraintValidator<UniqueRoomNo, Integer>{
	@Autowired
	private RoomDAO roomdao;
	
	
	@Override
	public void initialize(UniqueRoomNo constraintAnnotation) {
	}

	@Override
	public boolean isValid(Integer roomNo, ConstraintValidatorContext context) {
		return roomdao.findRoomByNumber(roomNo) == null;
	}
	

}
