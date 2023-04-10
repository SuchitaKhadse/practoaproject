package com.Amazon;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.keywords.AmazonUIKeyword;

public class AmazonProductTest {
	/**
	 * Without Using KeyWords
	 */
	@Test

	public static void verifySearchResultMensWatch() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("branded watch for mens");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		driver.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.linkText("Analog Black Dial Men's Watch-TW000R438")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parenthandle = (String) it.next();
		String childhandle = it.next();
		driver.switchTo().window(childhandle);
		driver.findElement(By.cssSelector("input#mbb-offeringID-1")).click();
		WebElement element = driver.findElement(By.cssSelector("select#quantity"));
		Select select = new Select(element);
		select.selectByIndex(2);
		driver.findElement(By.cssSelector("input#add-to-cart-button")).click();
		driver.findElement(By.cssSelector("input[name=\"proceedToRetailCheckout\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("+919921484831");

		driver.findElement(By.cssSelector("input#continue")).click();
		driver.findElement(By.cssSelector("input#ap_password")).sendKeys("Abcd@123");
		driver.findElement(By.cssSelector("input#signInSubmit")).click();
	}

	@Test
	public void verifySearchResultForPoloMen() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("polo mens");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		driver.executeScript("window.scrollBy(0,300)");
		List<WebElement> elements = driver
				.findElements(By.cssSelector("span.a-size-base-plus.a-color-base.a-text-normal"));
		for (WebElement element : elements) {
			String title1 = element.getText();

			Assert.assertTrue(title1.contains("polo men"), "title doesnt contais polo" + title1);

		}
	}

	@Test
	public static void verifyThatClickOnBrandListOfMobilesThatBrandShouldPopulate() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("a[href=\"/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles\"]"))
				.click();
		driver.findElement(By.xpath("//span[text()=\"Redmi\"]")).click();
		List<WebElement> mobileList = driver.findElements(By.cssSelector("span.a-price-whole"));
		for (WebElement mobile : mobileList) {
			String mob = driver.getTitle();
			Assert.assertTrue(mob.contains("Redmi"), "list doesnt contain Redmi mobiles" + mob);
		}
	}

	/**
	 * With UsingUIKeywords
	 * 
	 */
	@Test
	public static void verifySearchResultMensWatchWithUIKeywords() {
		AmazonUIKeyword.openBrowser("Chrome");
		AmazonUIKeyword.launchUrl("https://www.Amazon.in");
		AmazonUIKeyword.enterText((By.cssSelector("input#twotabsearchtextbox")), "branded watch for mens");
		AmazonUIKeyword.clickOn(By.cssSelector("input#nav-search-submit-button"));
		AmazonUIKeyword.scrollWindow(("window.scrollBy(0, 300)"), "");
		AmazonUIKeyword.clickOn(By.linkText("Analog Black Dial Men's Watch-TW000R438"));
		AmazonUIKeyword.switchToWindowHandle("childhandle");
		AmazonUIKeyword.clickOn(By.cssSelector("input#mbb-offeringID-1"));
		AmazonUIKeyword.clickOn(By.cssSelector("select#quantity"));
		AmazonUIKeyword.selectDropDown();
	}
}
