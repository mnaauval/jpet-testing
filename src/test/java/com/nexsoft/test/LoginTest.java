package com.nexsoft.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nexsoft.pom.SignInPage;
import com.nexsoft.utilities.Utilities;

public class LoginTest {

	private WebDriver driver;
	private SignInPage signIn;
	private Utilities util;

	@BeforeClass
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/actions/Account.action?signonForm=");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		signIn = PageFactory.initElements(driver, SignInPage.class);
		util = new Utilities();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void goToUrl() {
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void validLogin() {
		signIn.login("kaeka", "admin123");
		util.sleep(3000);
	}

	@AfterClass
	public void closeConn() {
		util.sleep(3000);
		driver.close();
	}
}
