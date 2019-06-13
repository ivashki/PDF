package com.frantishex.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.frantishex.model.DBFile;
import com.frantishex.model.ReservationDTO;
import com.frantishex.response.UploadFileResponse;
import com.frantishex.service.ExcelGenerator;
import com.frantishex.service.FileService;
import com.frantishex.service.ReservationService;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping
public class PrintToPDFController {

	@Autowired
	private FileService fileService;
	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/printPDF", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> printPDF(@RequestBody ReservationDTO reservationDetails)
			throws IOException, DocumentException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.add("Content-Disposition", "attachment; filename=\"ticket.pdf\"");

		byte[] pdfData = reservationService.reservationReport(reservationDetails);
		headers.setContentLength(pdfData.length);

		return new ResponseEntity<byte[]>(pdfData, headers, HttpStatus.OK);
	}

	@GetMapping(value = "/downloadReport")
	public ResponseEntity<InputStreamResource> excelReport() throws IOException {
		List<DBFile> files = fileService.getAll();

		ByteArrayInputStream in = ExcelGenerator.fileToExcel(files);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
		headers.add("Content-Disposition", "attachment; filename=\"report.xlsx\"");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

	@PostMapping("/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
		DBFile dbFile = fileService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/dowloadFile/")
				.path(dbFile.getId()).toUriString();

		return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());

	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<?> downloadFile(@PathVariable String fileId) {

		DBFile dbFile = fileService.getFile(fileId);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.add("Content-Disposition", "attachment; filename=\"ticket.pdf\"");

		return new ResponseEntity<byte[]>(dbFile.getData(), headers, HttpStatus.OK);

	}

}
