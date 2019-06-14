package com.frantishex.model;

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
	private String typeOfDocument;

	private String fileType;

	@Lob
	private byte[] data;

	public DBFile() {

	}

	public DBFile(String typeOfDocument, String fileType, byte[] data) {
		this.typeOfDocument = typeOfDocument;
		this.fileType = fileType;
		this.data = data;
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

	public String getTypeOfDocument() {
		return typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	public DBFile(String typeOfDocument, byte[] data) {
		this.typeOfDocument = typeOfDocument;
		this.data = data;
	}

}