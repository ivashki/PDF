package com.frantishex.controller;

import java.math.BigDecimal;

public class ReservationDTO {

	private String firstName;

	private String lastName;

	private String fromCity;

	private String toCity;

	private BigDecimal ticketPrice;

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
