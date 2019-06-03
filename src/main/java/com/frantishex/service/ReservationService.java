package com.frantishex.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.frantishex.controller.ReservationDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

@Service
@Transactional
public class ReservationService {

	public byte[] reservationReport(ReservationDTO r) throws DocumentException, MalformedURLException, IOException {

		Font bold = new Font(FontFamily.HELVETICA, 50.0f, Font.BOLD, BaseColor.RED);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Document document = new Document(PageSize.A4, 25, 25, 20, 20);

		PdfWriter writer = PdfWriter.getInstance(document, out);

		document.open();

		Image img = Image.getInstance("D:/Image folder/frantishex20140305-1019-qfe3g5.png");

		img.scaleAbsolute(250f, 150f);

		img.setSpacingAfter(15f);

		document.add(img);

		Paragraph p1 = new Paragraph("Bus Ticket",
				FontFactory.getFont(FontFactory.COURIER_BOLD, 20, Font.UNDERLINE, (new BaseColor(178, 109, 24))));

		p1.setFont(bold);

		p1.setAlignment(Paragraph.ALIGN_CENTER);

		p1.setSpacingAfter(20f);

		document.add(p1);

		PdfPTable table1 = new PdfPTable(3);
		table1.getDefaultCell().setBorder(0);

		table1.addCell(new Paragraph(" Name of the passenger :",
				FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.ITALIC, (new BaseColor(0, 0, 0)))));
		table1.addCell(new Phrase(r.getFirstName()));
		table1.addCell(new Phrase(r.getLastName()));
		table1.setSpacingAfter(20f);
		document.add(table1);

		PdfPTable table2 = new PdfPTable(3);
		table2.getDefaultCell().setBorder(0);

		table2.addCell(new Paragraph(" Price :",
				FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.ITALIC, (new BaseColor(0, 0, 0)))));
		table2.addCell(new Phrase("" + r.getTicketPrice() + ""));
		table2.addCell(new Phrase(" lv "));
		table2.setSpacingAfter(20f);
		document.add(table2);

		PdfPTable table3 = new PdfPTable(3);
		table3.getDefaultCell().setBorder(0);

		table3.addCell(new Paragraph(" Seat :",
				FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.ITALIC, (new BaseColor(0, 0, 0)))));
		table3.addCell(new Phrase("" + r.getSeatNumber() + ""));
		table3.addCell(new Phrase(""));
		table3.setSpacingAfter(20f);
		document.add(table3);

		document.add(new Chunk(l));

		PdfPTable table4 = new PdfPTable(3);
		table4.getDefaultCell().setBorder(0);

		table4.addCell(new Paragraph(" Route :",
				FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.ITALIC, (new BaseColor(0, 0, 0)))));
		table4.addCell(new Phrase(r.getFromCity()));
		table4.addCell(new Phrase(r.getToCity()));
		table4.setSpacingAfter(20f);
		document.add(table4);

		writer.flush();

		document.close();

		return out.toByteArray();

	}

}
