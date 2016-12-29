package com.jungle.resort.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;


@Entity
public class Room {
	@Id
	@GeneratedValue
	private int id;
	
	@Min(value=1)
	private int dailyRent;
	
	@Enumerated(EnumType.STRING)
	private RoomStatus status;

	@Enumerated(EnumType.STRING)
	private RoomType type;
	
	@Enumerated(EnumType.STRING)
	private RoomCategory category;
	
	@Lob
	private byte[] image;
	
	public Room(){};

	public int getDailyRent() {
		return dailyRent;
	}

	public void setDailyRent(int dailyRent) {
		this.dailyRent = dailyRent;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public RoomCategory getCategory() {
		return category;
	}

	public void setCategory(RoomCategory category) {
		this.category = category;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
