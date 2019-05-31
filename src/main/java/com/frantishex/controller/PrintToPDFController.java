package com.frantishex.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frantishex.service.ReservationService;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping
public class PrintToPDFController {

	@Autowired
	ReservationService reservationService;

	@RequestMapping(value = "/printPDF", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> printPDF(@RequestBody ReservationDTO reservationDetails) throws IOException, DocumentException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.add("Content-Disposition", "attachment; filename=\"ticket.pdf\"");

		byte[] pdfData = reservationService.reservationReport(reservationDetails);
		headers.setContentLength(pdfData.length);

		return new ResponseEntity<byte[]>(pdfData, headers, HttpStatus.OK);
	}

}