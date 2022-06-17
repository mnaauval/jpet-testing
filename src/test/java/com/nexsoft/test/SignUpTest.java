package com.nexsoft.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nexsoft.pom.UserAuthPage;
import com.nexsoft.utilities.Utilities;

public class SignUpTest {
	
	private WebDriver driver;
	private UserAuthPage userAuth;
	private Utilities util;
	private String attribute;

	@BeforeClass
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
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
	
//	UID

	@Test(priority = 1, testName = "Input empty field")
	public void signUpEmptyField() {
		userAuth.inputRegisterData();
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 2)
	public void blankUID() {
		attribute = userAuth.inputUID("");
		Assert.assertEquals(attribute, "");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 3)
	public void textUID() {
		attribute = userAuth.inputUID("abc");
		Assert.assertEquals(attribute, "abc");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 4)
	public void numUID() {
		attribute = userAuth.inputUID("123");
		Assert.assertEquals(attribute, "123");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 5)
	public void spCharUID() {
		attribute = userAuth.inputUID("*&(*");
		Assert.assertEquals(attribute, "*&(*");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 6)
	public void validUID() {
		attribute = userAuth.inputUID("hcg-11");
		Assert.assertEquals(attribute, "hcg-11");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
//	Passwd
	
	@Test(priority = 7)
	public void newPasswd_lenSix() {
		attribute = userAuth.inputPasswd("admin123");
		Assert.assertEquals(attribute, "admin123");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 8)
	public void validNewPasswd_lenNotSix() {
		attribute = userAuth.inputPasswd("admin");
		Assert.assertEquals(attribute, "admin");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 9)
	public void validNewPasswd_spChar() {
		attribute = userAuth.inputPasswd("admin_123");
		Assert.assertEquals(attribute, "admin_123");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 10)
	public void validNewPasswd_noSpChar() {
		attribute = userAuth.inputPasswd("admina123");
		Assert.assertEquals(attribute, "admina123");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 11)
	public void blankNewPasswd() {
		attribute = userAuth.inputPasswd("");
		Assert.assertEquals(attribute, "");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
	@Test(priority = 12)
	public void validNewPasswd() {
		attribute = userAuth.inputPasswd("adminRengo123");
		Assert.assertEquals(attribute, "adminRengo123");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
	
//	First Name
	
	@Test(priority = 100, testName = "Input valid field")
	public void signUpValidUser() {
		userAuth.inputRegisterData("hcg-11", "admin123", "admin123", "Raja", "Cupang", "rajacupang@gmail.com",
				"081234567890", "NWB 16, Tangerang", "Imam Bonjol 15, Nganjuk", "Tangerang", "Banten", "61123",
				"Indonesia");
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}

	@AfterClass
	public void closeConn() {
		util.sleep(3000);
		driver.close();
	}
}
