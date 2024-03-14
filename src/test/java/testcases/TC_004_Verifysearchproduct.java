package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Searchpage;
import testbase.Baseclasss;

public class TC_004_Verifysearchproduct extends Baseclasss {
    @Test(groups = {"master"})
	public void testsearch() {
		try {
			
		
    	Homepage hp = new Homepage(driver);
		hp.searchproduct("mac");
		hp.searchbutton();
		
		Searchpage sp = new Searchpage(driver);
		
		sp.ismyproductexist("MacBook Air");
	
		Assert.assertEquals(sp.ismyproductexist("MacBook Air"), true);
    } catch (Exception e) {
		Assert.fail();
	}
	}
	
	
	
	
	
}
