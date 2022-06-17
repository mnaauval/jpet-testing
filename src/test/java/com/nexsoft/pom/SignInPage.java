package com.nexsoft.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "a[href='/actions/Account.action?newAccountForm=']")
	private WebElement registerBtn;
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userID;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwd;
	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;
	
	public UserAuthPage clickRegister() {
		registerBtn.click();
		return PageFactory.initElements(driver, UserAuthPage.class);
	}
	
	public CatalogActionPage login(String UID, String password) {
		userID.sendKeys(UID);
		passwd.sendKeys(password);
		loginBtn.click();
		return PageFactory.initElements(driver, CatalogActionPage.class);
	}
}
