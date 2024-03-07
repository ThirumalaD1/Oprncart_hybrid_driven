package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage {
WebDriver driver;
public Myaccountpage(WebDriver driver) {
	super(driver);	
	}
	
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")  WebElement myAccounttext;
	@FindBy(xpath="//div[@class='list-group']/a[text()='Logout']")  WebElement logout;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement continuelo_btn;
	
	
	
	public boolean checkMyaccpageexist() {
		try {	
		return (myAccounttext.isDisplayed());
		} catch (Exception e) {
			return (false);
		}

	}
	public void clicklogout() {
		logout.click();
	}
	public void contine_logoutbtn() {
		continuelo_btn.click();
	}
	
}
