package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getDataFromExcelSheel(String sheet, int row, int col) throws EncryptedDocumentException, IOException {
		
		String data;
		
		String path = System.getProperty("user.dir");
	
		FileInputStream file = new FileInputStream(path +"\\src\\main\\resources\\Credentials\\TestDataKite.xlsx");	
		
		Cell cell = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(col);
		
		try {
			
			data = cell.getStringCellValue();
			
		}
		catch(IllegalStateException e)
		{
			double value = cell.getNumericCellValue();
			
			data = new BigDecimal(value).toPlainString();
		}
		
		return data;
	}
	
	public static void captureScreenshot(WebDriver driver, String testID) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date dt = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("dd_MM_YYYY hh_mm_ss");
		
		String date = format.format(dt);
		
		String path = System.getProperty("user.dir");
		
		File file = new File(path+"\\Screenshot\\"+testID+"_"+date+".jpg");
		
		FileHandler.copy(source, file);
	}
	
	
	
	
	
	
}
