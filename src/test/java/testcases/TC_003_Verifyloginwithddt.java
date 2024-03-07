package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import testbase.Baseclasss;
import utilities.Dataprovlogin;

public class TC_003_Verifyloginwithddt extends Baseclasss {
	@Test(dataProvider = "logindata", dataProviderClass =Dataprovlogin.class)
	public void testloginwithddt(String email, String pass, String exp) throws InterruptedException {
	try {
		
	
		Homepage hp = new Homepage(driver);
		mywaits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='My Account']")));
		hp.Myaccount();
		hp.loginlink();
		
	Loginpage lp = new Loginpage(driver);
		
		lp.enterEmail(email);
		lp.enterPass(pass);
		lp.clickLogin();
		Myaccountpage macc = new Myaccountpage(driver);
		
		Boolean targetpage =macc.checkMyaccpageexist();
		
		if (exp.equalsIgnoreCase("valid")) {
			if (targetpage==true) {
				macc.clicklogout();
				macc.contine_logoutbtn();
				Assert.assertTrue(true);
			} else {
				
           Assert.assertTrue(false);
           log.info("Invalidlogin");
			}
		}
		 if (exp.equalsIgnoreCase("invalid")) {
			if (targetpage==true) {
				macc.clicklogout();
				macc.contine_logoutbtn();
				Assert.assertTrue(false);
				log.info("Able to login with invalid cred");
			}else {
				log.info("Unable to login with invalid cred");
				Assert.assertTrue(true);
				
		}
		 }
		 }catch (Exception e) {
			   Assert.fail();
	}
	}
	}
