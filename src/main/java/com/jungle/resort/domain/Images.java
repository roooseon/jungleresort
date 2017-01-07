package com.jungle.resort.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Images {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Lob
	private byte[] image3;
	
	@Transient
	private String encodeImage3; 
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage3() {
		return image3;
	}

	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}

	public String getEncodeImage3() {
		return encodeImage3;
	}

	public void setEncodeImage3(String encodeImage3) {
		this.encodeImage3 = encodeImage3;
	}

	
	
	
	
	
}
