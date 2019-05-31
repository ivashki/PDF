package com.frantishex.service;

import java.io.ByteArrayOutputStream;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.frantishex.controller.ReservationDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@Transactional
public class ReservationService {

	public byte[] reservationReport(ReservationDTO r) throws DocumentException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Document document = new Document(PageSize.A4, 25, 25, 20, 20);

		PdfWriter writer = PdfWriter.getInstance(document, out);

		document.open();

		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(60);
		table.setWidths(new int[] { 1, 3, 3 });

		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

		PdfPCell hcell;
		hcell = new PdfPCell(new Phrase("Id", headFont));
		hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(hcell);

		hcell = new PdfPCell(new Phrase("Name", headFont));
		hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(hcell);

		hcell = new PdfPCell(new Phrase("Population", headFont));
		hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(hcell);

		PdfPCell cell;

		cell = new PdfPCell(new Phrase(r.getFirstName()));
		cell.setPaddingLeft(5);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(r.getFromCity()));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setPaddingRight(5);
		table.addCell(cell);

		document.add(table);

		writer.flush();

		document.close();

		return out.toByteArray();

	}

}
