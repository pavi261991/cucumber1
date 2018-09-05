package cucu.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Base {
	public WebDriver getDriver(String url) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\madhan\\eclipse-workspace\\pavi\\selenium\\driver\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get(url);

		return dr;
	}
	public String readDataFormExcel(int rowNo,int cellNo) throws IOException {
		File excel=new File("C:\\Users\\madhan\\eclipse-workspace\\pavimaven\\excel\\data.xlsx");
		FileInputStream stream = new	FileInputStream(excel);
		 XSSFWorkbook w = new XSSFWorkbook(stream);
		 XSSFSheet s = w.getSheet("adactin");
		XSSFRow r = s.getRow(rowNo);
		XSSFCell c = r.getCell(cellNo);
		int k = c.getCellType();
		String name ="";
		if(k==1) {
		 name = c.getStringCellValue();
		}
		if(k==0) {
			if(DateUtil.isCellDateFormatted(c)) {
				SimpleDateFormat formate=new SimpleDateFormat("dd/mmm/yyyy");
				name=formate.format(c.getDateCellValue());
			}else {
				name=String.valueOf((long)c.getNumericCellValue());
			}
		}
		return name;

	}
	public String writeDataToExcel(int rowNo,int cellNo ,String value) throws IOException {
		File excel=new File("C:\\Users\\madhan\\eclipse-workspace\\pavimaven\\excel\\data.xlsx");
		FileInputStream stream = new	FileInputStream(excel);
		 XSSFWorkbook w = new XSSFWorkbook(stream);
		 XSSFSheet s = w.getSheet("adactin");
		 XSSFRow r = s.createRow(rowNo);
			XSSFCell c = r.createCell(cellNo);
			c.setCellValue(value);
			FileOutputStream o=new FileOutputStream(excel);
			w.write(o);
			return value;
			
			

	}
	


	public void type(WebElement element,String name) {
	element.sendKeys(name);
		}

	public void clickButton(WebElement element) {
		element.click();
	}

	public void qiutBrower(WebDriver dr) {
		dr.quit();
	}

	public void getCurrenturl(WebDriver dr) {
		  String url = dr.getCurrentUrl();
		  System.out.println(url);
		
		
	}

	public void getTitle(WebDriver dr) {
		String ti = dr.getTitle();
		System.out.println(ti);
	}

	public void moveToElements(WebElement element, WebDriver dr) {
		Actions ac = new Actions(dr);
		ac.moveToElement(element).perform();
	}

	public void dragAndDrop(WebDriver dr, WebElement e1, WebElement e2) {
		Actions ac = new Actions(dr);
		ac.dragAndDrop(e1, e2).perform();
	}

	public void simpleAlert(WebDriver dr) {
		Alert a = dr.switchTo().alert();
		a.accept();

	}

	public void confirmAlert(WebDriver dr) {
		Alert a = dr.switchTo().alert();
		a.dismiss();

	}

	public void promptAlert(WebDriver dr, String text) {
		Alert a = dr.switchTo().alert();
		a.sendKeys(text);
		String t = a.getText();
		System.out.println(t);
		a.accept();
	}

	public void displayText(WebElement element) {
		 String t = element.getText();
		 System.out.println(t);
		

	}

	public void scrollDown(WebDriver dr, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void scrollUp(WebDriver dr, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public String getAttributeValue(WebElement element) {
		String name = element.getAttribute("value");
		return name;
		

	}

	public void dobleClick(WebElement element, WebDriver dr) {
		Actions ac = new Actions(dr);
		ac.doubleClick(element).perform();

	}

	public void rightClick(WebElement element, WebDriver dr) {
		Actions ac = new Actions(dr);
		ac.contextClick(element).perform();

	}
	public void keyPrndRele(int keyEvent)throws AWTException {
		Robot r=new Robot();
		r.keyPress(keyEvent);
		r.keyRelease(keyEvent);
		
		
	}
	public void keyPress(int keyEvent) throws AWTException {
		Robot r=new Robot();
		r.keyPress(keyEvent);
		
		
	}
	public void keyRelease(int keyEvent) throws AWTException {
		Robot r=new Robot();
		r.keyPress(keyEvent);
		
	}
	
	


}
