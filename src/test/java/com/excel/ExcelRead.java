package com.excel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelRead {
	@Test
	public void testExcel() throws Exception {
		DataFormatter df = new DataFormatter();// to convert any data type into
												// string we use this class
		FileInputStream fis = new FileInputStream("excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);// Factory for creating the
													// appropriate kind of Workbook
		Sheet sh = wb.getSheet("Sheet2");
		int rows = sh.getLastRowNum();// rows count wrt index >> 0123 like this
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				String cellValue = df.formatCellValue(c);// converting any data
															// type of any cell
															// into string
				System.out.print(cellValue + "      ");
			}
			System.out.println();
		}

	}

}
