package com.excel;

import java.io.FileInputStream;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dp {
	public static void main(String[] args) throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(1);
		int rows = sh.getLastRowNum();
		String[][] cellData = new String[rows + 1][];
		for (int i = 0; i <= rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			cellData[i] = new String[cols];

			for (int j = 0; j < cols; j++) {
				Cell cell = sh.getRow(i).getCell(j);
				cellData[i][j] = df.formatCellValue(cell);
			}
		}
		for (int i = 0; i < cellData.length; i++) {
			for (int j = 0; j < cellData[i].length; j++) {
				System.out.print(cellData[i][j]+"   ");
			}
	System.out.println();
		}
		}

}
