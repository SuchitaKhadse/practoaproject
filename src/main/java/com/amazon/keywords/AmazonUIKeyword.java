package com.amazon.keywords;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonUIKeyword {
	public static RemoteWebDriver driver;

	public static void openBrowser(String browsrName) {
		if (browsrName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		} else if (browsrName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browsrName.equalsIgnoreCase("internetexplorer")) {
			driver = new InternetExplorerDriver();

		}

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void driverClose() {
		driver.close();

	}

	public static void enterText(By by, String text) {
		driver.findElement(by).sendKeys(text);

	}

	public static void clickOn(By cssSelector) {
		driver.findElement(cssSelector).click();

	}

	public static String scrollWindow(String x, String y) {
		driver.executeScript("window.scrollBy(0,300)");
		return y;
	}

	public static void switchToWindowHandle(String S) {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parenthandle = (String) it.next();
		String childhandle = it.next();
		driver.switchTo().window(childhandle);

	}
	public static  void selectDropDown(WebElement element) {
		
		Select select = new Select(element);
		
		select.selectByIndex(0);
		
	
	}

}
