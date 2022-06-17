package com.nexsoft.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontPage {

	WebDriver driver;

	public FrontPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "a[href='actions/Catalog.action']")
	private WebElement enterStore;
	
	public CatalogActionPage clickEnterStore() {
		enterStore.click();
		return PageFactory.initElements(driver, CatalogActionPage.class);
	}
}
