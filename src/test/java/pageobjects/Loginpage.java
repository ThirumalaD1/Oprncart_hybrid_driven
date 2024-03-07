package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {
WebDriver driver;
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")  WebElement eMailAddress;
	@FindBy(xpath="//input[@id='input-password']")  WebElement password;
	@FindBy(xpath="//input[@value='Login']")  WebElement login;
	
	
	public void enterEmail(String email) {
		eMailAddress.sendKeys(email);
	}
	
	public void enterPass(String pass) {
		password.sendKeys(pass);
	}
	public void clickLogin() {
		login.click();
	}
	
}
