package AlainVelasquez.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AlainVelasquez.AbstractComponents.Waits;

public class PageOrder extends Waits {
	
	WebDriver driver;

	public PageOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[2]")
	List<WebElement> nameOfProduct;
	
	public Boolean verifyProductName(String desiredProduct) {
		Boolean match = nameOfProduct.stream().anyMatch(s -> s.getText().equalsIgnoreCase(desiredProduct));
		return match;
	}
	
	

}
