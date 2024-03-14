package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchpage extends Basepage {
	WebDriver driver;

	public Searchpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/div[3]//img")  List<WebElement> searchproductlist;
		
	@FindBy(xpath="//input[@id='input-quantity']") WebElement qty;
	
	@FindBy(xpath="//button[@id='button-cart']") WebElement addToCart;
	
	@FindBy(xpath="//div[contains(text(),'You have added')]") WebElement cnf_msg; 
	
	
	
	
	public boolean ismyproductexist(String product_name) {
		boolean status=false;
		for ( WebElement product : searchproductlist) {
		 
			if (product.getAttribute("Title").equals(product_name)){
				
				status= true;
			}
			
			
		}
		return status;
		
	}
	
	public void selectproduct(String product_name) {
		
		for (WebElement product : searchproductlist) {
			if (product.getAttribute("Title").equals(product_name)) {
				product.click();
			}
		}
		
	}
	
	public void setquantity(String quantity) {
		qty.clear();
		qty.sendKeys(quantity);
	}
	
	public void Clickaddtocart_btn() {
		addToCart.click();
	}
	public boolean check_cnfmsg() {
		try {
			return(cnf_msg.isDisplayed());	
		} catch (Exception e) {
			return (false);
		}
	}
	
}
