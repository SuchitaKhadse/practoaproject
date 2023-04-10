package com.amazon.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amazon.keywords.AmazonUIKeyword;


public class AmazonTestBase {
	@BeforeMethod
	public void setUp() throws Exception {
		AmazonUIKeyword.openBrowser("Chrome");
		AmazonUIKeyword.launchUrl("https://www.Amazon.in");
	}

	@AfterMethod
	public void tearDown() throws Exception {

		AmazonUIKeyword.driverClose();
	}

}
