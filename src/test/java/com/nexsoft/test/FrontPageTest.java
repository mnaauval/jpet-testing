package com.nexsoft.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nexsoft.pom.FrontPage;
import com.nexsoft.utilities.Utilities;

public class FrontPageTest {

	private WebDriver driver;
	private FrontPage frontPage;
	private Utilities util;

	@BeforeClass
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		frontPage = PageFactory.initElements(driver, FrontPage.class);
		util = new Utilities();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void goToUrl() {
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void goToCatalogAction() {
		frontPage.clickEnterStore();
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}

	@Test(priority = 2)
	public void goToSignIn() {
		frontPage.clickEnterStore().clickSignIn();
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}

	@Test(priority = 3)
	public void goToRegisterForm() {
		frontPage.clickEnterStore().clickSignIn().clickRegister();
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}

	@AfterClass
	public void closeConn() {
		util.sleep(3000);
		driver.close();
	}
}
