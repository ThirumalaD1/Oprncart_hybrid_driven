package testcases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import testbase.Baseclasss;

public class TC_002_Verifylogin extends Baseclasss {
	@Test(groups= {"master","regression"})
	public void logintest() {
		log.info("TC_002_Verifylogin is started");
		log.debug("debug logs started");
		try {
			
		
		Homepage hp = new Homepage(driver);
		hp.Myaccount();
		hp.loginlink();
		
		Loginpage lp = new Loginpage(driver);
		lp.enterEmail(p.getProperty("email"));
		log.info("Entered email");
		lp.enterPass(p.getProperty("password"));
		log.info("password entered");
		lp.clickLogin();
		log.info("Clicked login");
		Myaccountpage mac=new Myaccountpage(driver);
		if (mac.checkMyaccpageexist()==true) {
			Assert.assertTrue(true);
			log.info("Login passed");
		}else {

			Assert.fail();
		}
		
		} catch (Exception e) {
			log.info("Login Test failed");
			Assert.fail();
		}
		
		
		
	}
	
	

}
