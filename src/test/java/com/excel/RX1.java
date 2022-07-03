package com.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class RX1 {
	@Test
	public void m1() throws Exception, InvalidFormatException, IOException{
FileInputStream fis = new FileInputStream("excel.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Sheet4");
int rows  =  sh.getLastRowNum();
System.out.println(rows);
int cols = sh.getRow(1).getLastCellNum();
System.out.println(cols);

	}

}
