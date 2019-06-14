package com.frantishex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fileType;

	private String nameOfThePassenger;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getNameOfThePassenger() {
		return nameOfThePassenger;
	}

	public void setNameOfThePassenger(String nameOfThePassenger) {
		this.nameOfThePassenger = nameOfThePassenger;
	}

}
