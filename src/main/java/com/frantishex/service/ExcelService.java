package com.frantishex.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.frantishex.model.Report;

@Service
public class ExcelService extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		Sheet sh = book.createSheet("Pdf report details");

		Row headerRow = sh.createRow(0);

		headerRow.createCell(0).setCellValue("ID");

		List<Report> rList = (List) map.get("reports");

		if (!rList.isEmpty()) {
			int rowIndex = 1;
			for (Report r : rList) {
				Row dataRow = sh.createRow(rowIndex);
				dataRow.createCell(0).setCellValue(rowIndex);
				dataRow.createCell(1).setCellValue(r.getId());
				dataRow.createCell(2).setCellValue(r.getName());
				rowIndex++;
			}
		}
	}

}
