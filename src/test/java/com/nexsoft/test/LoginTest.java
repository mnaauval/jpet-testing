package com.nexsoft.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nexsoft.pom.UserAuthPage;
import com.nexsoft.utilities.Utilities;

public class LoginTest {
	
	private WebDriver driver;
	private UserAuthPage userAuth;
	private Utilities util;

	@BeforeClass
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/actions/Account.action?signonForm=");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		userAuth = PageFactory.initElements(driver, UserAuthPage.class);
		util = new Utilities();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void goToUrl() {
		driver.get(System.getProperty("url"));
	}
	
	@Test(priority = 1)
	public void validLogin() {
		
	}
}
