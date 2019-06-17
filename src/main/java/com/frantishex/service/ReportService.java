package com.frantishex.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.frantishex.model.Report;
import com.frantishex.model.ReservationDTO;

@Service
@Transactional
public class ReportService {
	@PersistenceContext
	EntityManager em;

	public Report createReport(ReservationDTO r) {
		Report report = new Report();
		report.setNameOfThePassenger(r.getFirstName() + " " + r.getLastName());
		report.setFileType("PDF");
		report.setTrip(r.getFromCity() + " - " + r.getToCity());
		report.setDateOfIssue(r.getDate());
		em.merge(report);
		return report;
	}

	public List<Report> getAll() { 	
		return em.createQuery("select r from Report r", Report.class).getResultList();
	}

}
