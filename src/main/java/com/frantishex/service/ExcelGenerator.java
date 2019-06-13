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

import com.frantishex.model.DBFile;

@Service
@Transactional
public class ExcelGenerator {

	public static ByteArrayInputStream fileToExcel(List<DBFile> file) throws IOException {
		String[] cols = { "Id", "Type of document", "Name of passenger", "Trip", "Date of issue" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("reports");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < cols.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(cols[col]);
				cell.setCellStyle(headerCellStyle);
			}

			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

			int rowIdx = 1;
			for (DBFile files : file) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(files.getId());
				row.createCell(1).setCellValue(files.getNameOfThePassenger());
				row.createCell(2).setCellValue(files.getNameOfThePassenger());
				row.createCell(3).setCellValue(files.getTrip());
				row.createCell(4).setCellValue(String.valueOf(files.getDateOfIssue()));

				Cell ageCell = row.createCell(3);
				ageCell.setCellValue(12);
				ageCell.setCellStyle(ageCellStyle);
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}