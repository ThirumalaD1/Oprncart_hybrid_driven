package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends Basepage {
WebDriver driver;
	public Accountregistrationpage(WebDriver driver) {
	super(driver);
	
}
	
	@FindBy(xpath="//input[@id='input-firstname']")  WebElement firstName;
	@FindBy(xpath="//input[@id='input-lastname']")  WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']")  WebElement eMail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']")  WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement passwordConfirm;
	@FindBy(xpath="//label[normalize-space()='Yes']")  WebElement yes;
	@FindBy(xpath="//input[@name='agree']") WebElement agree;
	@FindBy(xpath="//input[@value='Continue']") WebElement continue_btn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement Accountcreationmsg;
	public void setFirstname(String firstn) {
		firstName.sendKeys(firstn);
	}
	
	public void setLastname(String lastn) {
		lastName.sendKeys(lastn);
	}
	
	public void setEmail(String email) {
		eMail.sendKeys(email);
	}
	public void setphnnum(String phnnum) {
		telephone.sendKeys(phnnum);
	}
	
	public void setPassword(CharSequence pass) {
		password.sendKeys(pass);
	}
	public void setconfirmPassword(String confirmpass) {
		passwordConfirm.sendKeys(confirmpass);
	}
	public void setYes() {
		yes.click();
	}
	public void agree() {
		agree.click();
	}
	public void clickcontinue() {
		continue_btn.click();
	}
	
	public String checkAccountcreationmsg() {
		String acc_msg = Accountcreationmsg.getText();
		return acc_msg;
	}
}