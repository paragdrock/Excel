package com.excel;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sheetal {
	WebDriver  driver=null;
	
	public void before()
	{
		System.setProperty("webdriver.chrome.driver","C:/JBk/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/parag/javabykiran-Selenium-Softwares/Offline%20Website/index.html#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void test() throws Exception
	{
	DataFormatter df=new DataFormatter();
	FileInputStream fis=new FileInputStream("excel.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("Sheet1");
	int rows=sh.getLastRowNum();
	String user="";
   	String pwd="";
	for(int i=0;i<=rows;i++)
	{
		int cols=sh.getRow(i).getLastCellNum();
		for(int j=0;j<cols;j++)
		{
		Cell un=sh.getRow(i).getCell(0);
		Cell pass=sh.getRow(i).getCell(1);
	   	user=df.formatCellValue(un);
	   	 pwd=df.formatCellValue(pass);
	  	} 
	test01(user,pwd);
	}
	}
	
	@Test
	public void test01(String user, String pass)
	{  
		 before();
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		String gt=driver.getTitle();
		 driver.close();	
		 if(gt.equals("JavaByKiran | Dashboard"))
		 {
	   	 Assert.assertEquals(gt,"JavaByKiran | Dashboard");
		 }
		 else
		 {
			String e1= driver.findElement(By.id("//*[@id='email_error']")).getText();
			String p1= driver.findElement(By.id("//*[@id='passwordl_error']")).getText();
			Assert.assertEquals(e1, "Please enter email as kiran@gmail.com");
			Assert.assertEquals(p1, " Please enter password 123456");
		 }
	}
}
