package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Searchpage;
import testbase.Baseclasss;

public class TC_005_AddtocartpageTest extends Baseclasss {
   @Test(groups = {"master"})
	public void addtocarttest() {
		try {
			
		Homepage hp = new Homepage(driver);
		hp.searchproduct("mac");
		hp.searchbutton();
		
		Searchpage sp = new Searchpage(driver);
		
		if (sp.ismyproductexist("MacBook Pro")) {
			sp.selectproduct("MacBook Pro");
			sp.setquantity("2");
			sp.Clickaddtocart_btn();
			Assert.assertEquals(sp.check_cnfmsg(), true);
			
		}
		
		
		} catch (Exception e) {
			Assert.fail();
		}	
	
		}
		
		
	
	
	
	
}
