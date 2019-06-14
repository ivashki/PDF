package com.frantishex.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.frantishex.model.Report;
import com.frantishex.model.ReservationDTO;

@Service
public class ReportService {
	@PersistenceContext
	EntityManager em;

	public Report createReport(ReservationDTO r) {
		Report report = new Report();
		report.setNameOfThePassenger(r.getFirstName() + " " + r.getLastName());
		report.setFileType("PDF");
		em.merge(report);
		return report;
	}

}
