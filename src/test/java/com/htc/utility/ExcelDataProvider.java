package com.htc.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	ConfigDataProvider config=new ConfigDataProvider();

	public Object[][] webPage() throws IOException {
		String filePath;
		
		filePath=config.getexcelpath();
				
		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		Sheet sheet = workbook.getSheet("Searching");
		Row row2 = sheet.getRow(0);
		Object[][] userData = new Object[sheet.getLastRowNum()][row2.getLastCellNum()];
		int rowIndex = 0;
		// Iterate through each rows one by one
		for (int index = 1; index <= sheet.getLastRowNum(); index++) {
			Row row = sheet.getRow(index);
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();
			int index2 = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (evaluator.evaluateInCell(cell).getCellType()) {
				case NUMERIC:
					long data = (long) cell.getNumericCellValue();
					userData[rowIndex][index2] = data;
					break;
				case STRING:
					String data2 = cell.getStringCellValue();
					userData[rowIndex][index2] = data2;
					break;
				default:
					// Not again
					break;
				}
				index2++;
			}
			rowIndex++;
		}
		file.close();
		return userData;
	}
}
