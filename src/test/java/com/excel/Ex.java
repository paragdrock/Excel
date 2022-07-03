package com.excel;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Ex {
	@Test
	public void read() throws Exception{
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:/parag'sworkspaceKiranjbk/ExcelSheetReadingXlsx/excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet4");
    System.out.println("********************");
		int rows = sh.getLastRowNum();//8
		int cols = sh.getRow(0).getLastCellNum();
		String[][] cellData = new String[rows+1][cols];
		for (int i = 0; i <= rows; i++) {
			
			cellData[i] = new String[cols];

			for (int j = 0; j < cols; j++) {
				Cell cell = sh.getRow(i).getCell(j);
			cellData[i][j] = df.formatCellValue(cell);
			}
		}
		for (String[] strings : cellData) {
			System.out.println();
			for (String string : strings) {
				System.out.print(string+"   ");
			}
		}
	}

}
