package com.selemium.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Utility {

	public static String airline = System.getProperty("user.dir") + "/BaseInfomation/airline.xls";
	public static String airport = System.getProperty("user.dir") + "/BaseInfomation/airport.xls";

	public static WebElement getElementMethod_xpath(WebDriver webDriver, String xpath) {
		WebElement webElement = webDriver.findElement(By.xpath(xpath));
		return webElement;
	}

	public static void inputDataByJS(WebDriver driver, WebElement element, String value, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]." + attribute + "='" + value + "'", element);
	}

	public static void selectDropDownList(WebDriver driver, String xpath, String code, String speadsheetName) {

		SpeadsheetIO speadsheet = new SpeadsheetIO();
		InputStream is;
		String name = "";
		try {
			is = new FileInputStream(speadsheetName);
			name = speadsheet.getFullName(is, code);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> elements = getPassBackData(driver, xpath);

		for (WebElement webElement : elements) {
			if (webElement.getText().equals(name) || webElement.getText().equals(code)) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				webElement.click();
				break;
			}
		}
	}

	public static List<WebElement> getPassBackData(WebDriver driver, String xpath) {
		List<WebElement> elements = (new WebDriverWait(driver, 20)).until(new ExpectedCondition<List<WebElement>>() {

			@Override
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(By.xpath(xpath));
			}

		});

		return elements;
	}

	/**
	 * 
	 * @param length
	 * @param type
	 * @return random character[0:a-z¡¢1:A-Z,2:0-9]
	 */
	public static String generateRandomString(int length, int type) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			long result = 0;
			switch (type) {
			case 0:
				result = Math.round(Math.random() * 25 + 65);
				sb.append(String.valueOf((char) result));
				break;
			case 1:
				result = Math.round(Math.random() * 25 + 97);
				sb.append(String.valueOf((char) result));
				break;
			case 2:
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;
			}

		}
		return sb.toString();
	}

	public static void swtichToOtherTab(WebDriver webDriver, String title) {
		Set<String> allWindowsId = webDriver.getWindowHandles();
		for (String windowId : allWindowsId) {
			if (!webDriver.switchTo().window(windowId).getTitle().contains(title)) {
				webDriver.switchTo().window(windowId);
				break;
			}
		}
	}

	public static void snapshot(TakesScreenshot drivername, String filename) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name

		String currentPath = System.getProperty("user.dir"); // get current work
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			System.out.println("save snapshot path is:" + currentPath + "/" + filename);
			FileUtils.copyFile(scrFile, new File(currentPath + "\\screenshot\\" + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {

			System.out.println("screen shot finished");
		}
	}
	
	public static boolean waitElementPresenceByXpath(WebDriver driver, int waitTime, String xpath, int type)
	{
		WebDriverWait wait =new WebDriverWait(driver, waitTime);
		return wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver)
			{
				switch (type) {
				case 0:
					return driver.findElements(By.xpath(xpath)).size()==0;
				case 1:
					return driver.findElements(By.xpath(xpath)).size()>0;
				default:
					return false;
				}
			}
		});
	}
	
	public static void waitElementPresenceByAttribute(WebDriver driver, int waitTime, String xpath, String attrubite, String value)
	{
		WebDriverWait wait =new WebDriverWait(driver, waitTime);
		System.out.println(driver.findElement(By.xpath(xpath)).getAttribute(attrubite));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath(xpath)), attrubite, value));
		System.out.println(driver.findElement(By.xpath(xpath)).getAttribute(attrubite));
	}
	
}