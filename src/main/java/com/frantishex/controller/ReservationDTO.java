package com.frantishex.controller;

import java.math.BigDecimal;
import java.sql.Date;

public class ReservationDTO {

	private String firstName;

	private String lastName;

	private String fromCity;

	private String toCity;

	private BigDecimal seatNumber;

	private BigDecimal ticketPrice;

	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigDecimal getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(BigDecimal seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String clientFname) {
		this.firstName = clientFname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String clientLname) {
		this.lastName = clientLname;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String startCity) {
		this.fromCity = startCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String endCity) {
		this.toCity = endCity;
	}

	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
