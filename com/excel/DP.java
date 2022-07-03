package com.excel;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DP {
	@Test(dataProvider = "dp")
	public void f(String n, String s)
	{
		System.out.print();
	}

	@DataProvider
	public Object[][] dp() 
	{
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);
		int rows = sh.getLastRowNum();
		String [][] cellData = new String[rows][];
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < cols; j++) {
				Cell cell = sh.getRow(i).getCell(j);
				String cellValue = df.formatCellValue(cell);
				cellData[i][j]=cellData;
			}
		}
		System.out.println(Arrays.deepToString(cellData));
return cellData
	}
}
