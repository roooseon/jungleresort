package com.jungle.resort.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
	
	@Transient
	private List<MultipartFile> tempImg2;
  	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id")	   
	private List<Images> image2  = new ArrayList<>();
		
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


	public Integer getRoomNo() {
		return roomNo;
	}
	
	
	public List<MultipartFile> getTempImg2() {
		return tempImg2;
	}

	public void setTempImg2(List<MultipartFile> tempImg2) {
		this.tempImg2 = tempImg2;
	}

	public List<Images> getImage2() {
		return image2;
	}

	public void setImage2(List<Images> image2) {
		this.image2 = image2;
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

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNo=" + roomNo + ", dailyRent=" + dailyRent + ", roomStatus=" + roomStatus
				+ ", roomType=" + roomType + ", roomCategory=" + roomCategory + ", tempImg2=" + tempImg2 + ", image2="
				+ image2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dailyRent == null) ? 0 : dailyRent.hashCode());
		result = prime * result + id;
		result = prime * result + ((image2 == null) ? 0 : image2.hashCode());
		result = prime * result + ((roomCategory == null) ? 0 : roomCategory.hashCode());
		result = prime * result + ((roomNo == null) ? 0 : roomNo.hashCode());
		result = prime * result + ((roomStatus == null) ? 0 : roomStatus.hashCode());
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
		result = prime * result + ((tempImg2 == null) ? 0 : tempImg2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (dailyRent == null) {
			if (other.dailyRent != null)
				return false;
		} else if (!dailyRent.equals(other.dailyRent))
			return false;
		if (id != other.id)
			return false;
		if (image2 == null) {
			if (other.image2 != null)
				return false;
		} else if (!image2.equals(other.image2))
			return false;
		if (roomCategory != other.roomCategory)
			return false;
		if (roomNo == null) {
			if (other.roomNo != null)
				return false;
		} else if (!roomNo.equals(other.roomNo))
			return false;
		if (roomStatus != other.roomStatus)
			return false;
		if (roomType != other.roomType)
			return false;
		if (tempImg2 == null) {
			if (other.tempImg2 != null)
				return false;
		} else if (!tempImg2.equals(other.tempImg2))
			return false;
		return true;
	}
	
	
	
	
}
