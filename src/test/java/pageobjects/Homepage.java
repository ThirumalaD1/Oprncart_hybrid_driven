package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
public WebDriver driver;
	
	public Homepage(WebDriver driver) {
		 super(driver);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Search']") WebElement search;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement search_btn;

@FindBy(xpath="//span[normalize-space()='My Account']")  WebElement myAccount;

@FindBy(xpath="//a[normalize-space()='Register']") WebElement register;

@FindBy(xpath="//a[normalize-space()='Login']")  WebElement login;


public void searchproduct(String searchtext) {
	
	search.sendKeys(searchtext);
}

public void searchbutton() {
	
	search_btn.click();
}


public void Myaccount() {
	myAccount.click();
}
	public void registerlink() {
		register.click();
	}
	
	public void loginlink() {
		login.click();
	}
}
