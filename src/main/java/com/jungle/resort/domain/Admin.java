package com.jungle.resort.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Admin {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull (message="cannot be empty")
	private String username;
	
	@Size(min = 6, message = "Password should be at least 6 characters long")
	private String password;
	
	@NotEmpty
	@Email(message = "Invalid email")
	private String email;

}
