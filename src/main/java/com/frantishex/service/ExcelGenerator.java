package com.frantishex.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.frantishex.model.Report;

@Service
@Transactional
public class ExcelGenerator {

	public static ByteArrayInputStream reportToExcel(List<Report> report) throws IOException {
		String[] cols = { "Id", "Type of document", "Name of passenger", "Trip", "Date of issue" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("reports");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < cols.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(cols[col]);
				cell.setCellStyle(headerCellStyle);
			}

			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

			int rowIdx = 1;
			for (Report reports : report) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(reports.getId());
				row.createCell(1).setCellValue(reports.getFileType());
				row.createCell(2).setCellValue(reports.getNameOfThePassenger());
				row.createCell(3).setCellValue(reports.getTrip());
				row.createCell(4).setCellValue(String.valueOf(reports.getDateOfIssue()));

			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}