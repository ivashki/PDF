package com.frantishex.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.transaction.Transactional;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Transactional

public class DBFile {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "typeOfDocument", columnDefinition = "VARCHAR(128)")
	private String fileName;

	private String fileType;

	private String nameOfThePassenger;

	private String trip;

	private LocalDate dateOfIssue;

	@Lob
	private byte[] data;

	public DBFile() {

	}

	public DBFile(String fileName, String fileType, byte[] data) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public DBFile(String id, String fileName, String fileType, String nameOfThePassenger, String trip,
			LocalDate dateOfIssue, byte[] data) {
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.nameOfThePassenger = nameOfThePassenger;
		this.trip = trip;
		this.dateOfIssue = dateOfIssue;
		this.data = data;
	}

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

	public String getNameOfThePassenger() {
		return nameOfThePassenger;
	}

	public void setNameOfThePassenger(String nameOfThePassenger) {
		this.nameOfThePassenger = nameOfThePassenger;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public DBFile(String fileName, byte[] data) {
		this.fileName = fileName;
		this.data = data;
	}

}