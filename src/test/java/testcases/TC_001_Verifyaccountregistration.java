package testcases;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Accountregistrationpage;
import pageobjects.Homepage;
import testbase.Baseclasss;




public class TC_001_Verifyaccountregistration extends Baseclasss {
 	
	@Test(groups = {"master","sanity"})
	public void account_page() throws InterruptedException {
	
		log.info("TC_001_Verifyaccountregistration started");
		log.debug("Debug logs started");
		
		try {	
		Homepage hm = new Homepage(driver);
	
		hm.Myaccount();
		log.info("Clicked My account option");
		hm.registerlink();
		log.info("Clicked register option");
		log.info("Entering user details for registering user");
		Accountregistrationpage ac = new Accountregistrationpage(driver);
		ac.setFirstname(setrandomstring().toUpperCase());
		ac.setLastname(setrandomstring().toUpperCase());
		ac.setEmail(setrandomstring()+"@gmail.com");
		ac.setphnnum(setrandomnum());
		String pass=setAlphanum();
		ac.setPassword(pass);
		ac.setconfirmPassword(pass);
		ac.setYes();
		log.info("clicked on yes");
		ac.agree();
		log.info("clicked on agree");
		Thread.sleep(5000);
		ac.clickcontinue();
		log.info("clicked on continue button");
		
		Assert.assertEquals("Your Account Has Been Created!", ac.checkAccountcreationmsg()); 
		} catch (Exception e) {
			log.error("Test failed");
			Assert.fail();
		}
		log.info("Logs recording ended");
		log.info("TC_001_Verifyaccountregistration completed");
	
	}
	
	
	
}
