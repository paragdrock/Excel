package com.excel;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class NewTest {
	WebDriver driver =  null;	
	@Test(dataProvider = "dp")

	public void f(String uname, String pass,String errEmail, String errPass) 
	{
			System.setProperty("webdriver.chrome.driver", "C:/JBk/chromedriver.exe");
		driver =  new ChromeDriver();
		driver.get("file:///C:/parag/javabykiran-Selenium-Softwares/Offline%20Website/index.html#");
		
		if (driver.getTitle().equals("JavaByKiran | Dashboard"))
			driver.findElement(By.partialLinkText("LOGOUT")).click();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		if (driver.getTitle().equals("JavaByKiran | Dashboard"))
			Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		else {
			Assert.assertEquals(driver.findElement(By.id("email_error")).getText(), errEmail);
			Assert.assertEquals(driver.findElement(By.id("password_error")).getText(), errPass);
		}
		
	}

	@DataProvider
	public Object[][] dp() throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
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
	/*	for (String[] strings : cellData) {
			System.out.println();
			for (String string : strings) {
				System.out.print(string+"   ");
			}
		}*/
		return cellData;
	
	}
}
