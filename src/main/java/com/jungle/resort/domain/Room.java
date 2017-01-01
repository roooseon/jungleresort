package com.jungle.resort.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.jungle.resort.annotations.DropdownSelect;
import com.jungle.resort.annotations.UniqueRoomNo;


@Entity
public class Room {
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull(message="Please enter Room No")
	@Min(value=1)
	@Column(unique=true)
	//@UniqueRoomNo(message="Room No already exits")
	private Integer roomNo;
	
	@Min(value=1)
	@NotNull(message="Please enter Rent Amount")
	private Integer dailyRent;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="Please select Room Status")
//	@DropdownSelect(message="Please select one")
	private RoomStatus roomStatus;

//	@DropdownSelect(message="Please select one")
	@Enumerated(EnumType.STRING)
	@NotNull(message="Please select Room Type")
	private RoomType roomType;
	
//	@DropdownSelect(message="Please select one")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Please select Room Category")
	private RoomCategory roomCategory;
	
	@Lob
	private byte[] image;
	
	public Room(){};

	public Integer getDailyRent() {
		return dailyRent;
	}

	public void setDailyRent(Integer dailyRent) {
		this.dailyRent = dailyRent;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomCategory getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(RoomCategory roomCategory) {
		this.roomCategory = roomCategory;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
