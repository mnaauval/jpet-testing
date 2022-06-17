package com.nexsoft.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserAuthPage {

	WebDriver driver;

	public UserAuthPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userID;
	@FindBy(css = "input[name='password']")
	private WebElement newPasswd;
	@FindBy(css = "input[name='repeatedPassword']")
	private WebElement repPasswd;
	@FindBy(css = "input[name='account.firstName']")
	private WebElement firstName;
	@FindBy(css = "input[name='account.lastName']")
	private WebElement lastName;
	@FindBy(css = "input[name='account.email']")
	private WebElement email;
	@FindBy(css = "input[name='account.phone']")
	private WebElement phone;
	@FindBy(css = "input[name='account.address1']")
	private WebElement address1;
	@FindBy(css = "input[name='account.address2']")
	private WebElement address2;
	@FindBy(css = "input[name='account.city']")
	private WebElement city;
	@FindBy(css = "input[name='account.state']")
	private WebElement state;
	@FindBy(css = "input[name='account.zip']")
	private WebElement zipCode;
	@FindBy(css = "input[name='account.country']")
	private WebElement country;
	@FindBy(name = "account.languagePreference")
	private WebElement dropListLang;
	@FindBy(name = "account.favouriteCategoryId")
	private WebElement dropListFavCat;
	@FindBy(css = "input[value='true'][name='account.listOption']")
	private WebElement lstMyList;
	@FindBy(css = "input[value='true'][name='account.bannerOption']")
	private WebElement lstMyBanner;
	@FindBy(css = "input[value='Save Account Information']")
	private WebElement registerBtn;

	Select lang;
	Select favCat;

	public SignInPage inputRegisterData(String userID, String newPasswd, String repPasswd, String firstName,
			String lastName, String email, String phone, String address1, String address2, String city, String state,
			String zipCode, String country) {
		lang = new Select(dropListLang);
		favCat = new Select(dropListFavCat);
		this.userID.sendKeys(userID);
		this.newPasswd.sendKeys(newPasswd);
		this.repPasswd.sendKeys(repPasswd);
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		this.phone.sendKeys(phone);
		this.address1.sendKeys(address1);
		this.address2.sendKeys(address2);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.zipCode.sendKeys(zipCode);
		this.country.sendKeys(country);
		lang.selectByVisibleText("japanese");
		favCat.selectByVisibleText("REPTILES");
		lstMyList.click();
		lstMyBanner.click();
		registerBtn.click();
		
		return PageFactory.initElements(driver, SignInPage.class);
	}
	
	public UserAuthPage inputRegisterData() {
		registerBtn.click();
		return PageFactory.initElements(driver, UserAuthPage.class);
	}
	
	public String inputUID(String UID) {
		userID.sendKeys(UID);
		registerBtn.click();
		return userID.getAttribute("value");
	}
	
	public String inputPasswd(String passwd) {
		userID.clear();
		newPasswd.clear();
		newPasswd.sendKeys(passwd);
		registerBtn.click();
		return newPasswd.getAttribute("value");
	}
	
//	public String inputRepPasswd(String newPasswd, String repPasswd) {
//		userID.clear();
//		this.newPasswd.clear();
//		this.repPasswd.clear();
//		this.newPasswd.sendKeys(newPasswd);
//		this.repPasswd.sendKeys(repPasswd);
//		if (this.newPasswd.getAttribute("value") == this.repPasswd.getAttribute("value")) {
//			registerBtn.click();
//			return this.repPasswd.getAttribute("value");
//		} else {
//			registerBtn.click();
//			return null;
//		}
//	}
}
