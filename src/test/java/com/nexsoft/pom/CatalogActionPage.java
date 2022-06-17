package com.nexsoft.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogActionPage {

	WebDriver driver;

	public CatalogActionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "#MenuContent > a:nth-child(3)")
	private WebElement signInBtn;
	
	public SignInPage clickSignIn() {
		signInBtn.click();
		return PageFactory.initElements(driver, SignInPage.class);
	}
	
	public CatalogActionPage clickLogout() {
		return PageFactory.initElements(driver, CatalogActionPage.class);
	}
}
