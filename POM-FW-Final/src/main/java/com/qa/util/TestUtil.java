package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{

	
	public static long PAGE_LOAD_TIMEOUT=160;
	public static long IMPLICIT_WAIT=60;
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\areddy93\\eclipse-workspace\\POM-FW-Naveen\\src"
			+ "\\main\\java\\com\\qa\\testdata\\Testdatasheet.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream fis=null;
		
		try
		{
			fis=new FileInputStream(TESTDATA_SHEET_PATH);
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(fis);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					
				}
			
		}
		return data;
		
	}
	
	
	public static void takeScreenshotAtEnd() throws Exception{

		File SrcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir=System.getProperty("user.dir");
        
        FileUtils.copyFile(SrcFile, new File(currentDir +"\\screenshots\\" + System.currentTimeMillis() + ".png"));

    }
	
	
}
