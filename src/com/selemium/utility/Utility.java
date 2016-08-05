package com.selemium.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

	public static String airline = ClassLoader.getSystemResource("BaseInfomation").getPath().substring(1)
			+ "/airline.xls";
	public static String airport = ClassLoader.getSystemResource("BaseInfomation").getPath().substring(1)
			+ "/airport.xls";

	public static void inputDataByJS(WebDriver driver, WebElement element, String value, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]." + attribute + "='" + value + "'", element);
	}

	public static void selectDropDownListPerSpreadSheet(WebDriver driver, String xpath, String code,
			String speadsheetName) {
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
		selectDropDownList(driver, xpath, name);
	}

	public static void selectDropDownList(WebDriver driver, String xpath, String content) {

		List<WebElement> elements = getPassBackData(driver, xpath);

		for (WebElement webElement : elements) {

			String webContent = null;
			if (webElement.getText().matches("\\(.*\\)")) {

				webContent = webElement.getText().substring(1, webElement.getText().length() - 1);
			} else {
				webContent = webElement.getText();
			}

			if (webContent.equals(content)) {
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

	public static void swtichToOtherTabByTitle(WebDriver driver, String content) {
		Set<String> allWindowsId = driver.getWindowHandles();
		for (String windowId : allWindowsId) {
			if (driver.switchTo().window(windowId).getTitle().contains(content)) {
				driver.switchTo().window(windowId);
				break;
			}
		}
	}

	public static void swtichToOtherTabByURL(WebDriver driver, String url) {
		Set<String> allWindowsId = driver.getWindowHandles();
		for (String windowId : allWindowsId) {
			if (driver.switchTo().window(windowId).getCurrentUrl().contains(url)) {
				driver.switchTo().window(windowId);
				break;
			}
		}
	}
	
	public static void swtichToOtherTabByIndex(WebDriver driver, String index)
	{
		String tabIndex = Keys.chord(Keys.CONTROL, index);
		driver.findElement(By.tagName("body")).sendKeys(tabIndex);
	}

	public static void openNewTab(WebDriver driver, String href) {
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, "t");
		driver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);
		swtichToOtherTabByTitle(driver, "New Tab");
		driver.navigate().to(href);
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

	public static boolean waitElementPresenceByXpath(WebDriver driver, int waitTime, String xpath, int type) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		return wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				switch (type) {
				case 0:
					return driver.findElements(By.xpath(xpath)).size() == 0;
				case 1:
					return driver.findElements(By.xpath(xpath)).size() > 0;
				default:
					return false;
				}
			}
		});
	}

	public static void waitElementPresenceByAttribute(WebDriver driver, int waitTime, String xpath, String attrubite,
			String value) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath(xpath)), attrubite, value));
	}

	public static void waitURLnavigation(WebDriver driver, int waitTime, String partofURL) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.urlContains(partofURL));
	}

}