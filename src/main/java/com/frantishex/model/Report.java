package com.frantishex.model;

import java.time.LocalDate;

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

	private String trip;

	private LocalDate dateOfIssue;

	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

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
