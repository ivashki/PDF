package com.frantishex.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationDTO {

	private String firstName;

	private String lastName;

	private String fromCity;

	private String toCity;

	private BigDecimal seatNumber;

	private BigDecimal ticketPrice;

	private LocalDate date;

	private LocalDateTime time;

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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
