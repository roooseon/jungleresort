package com.jungle.resort.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int customerId;
	
	@Size(min = 6, message = "Password should be at least 6 characters long")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Size(min = 6, message = "Name should be at least 6 characters long")
	private String name;
	@Size(min = 6, message = "Username should be at least 6 characters long")
	private String username;
	@NotEmpty
	@Email(message = "Invalid email")
	private String email;
	@Size(min = 1, message = "Cannot be empty")
	private String phoneNumber;
	@Valid
	@Embedded
	private Address address;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
//	@OneToMany
//	private Room room;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
//
//	public Room getRoom() {
//		return room;
//	}
//
//	public void setRoom(Room room) {
//		this.room = room;
//	}

	public int getCustomerId() {
		return customerId;
	}	
}
