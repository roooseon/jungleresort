package com.jungle.resort.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Rent {
	@Id
	@GeneratedValue
	private int rentId;
	
	@Temporal(TemporalType.DATE)
	@Future
	private Date rentedDate;

	@Temporal(TemporalType.DATE)
	@Future
	private Date returnedDate;
	
	@OneToOne 
	private Room room;
	
	public Rent(){}
	
	
	
}
