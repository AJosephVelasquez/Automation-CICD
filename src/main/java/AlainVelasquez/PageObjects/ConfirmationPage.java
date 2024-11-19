package AlainVelasquez.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AlainVelasquez.AbstractComponents.Waits;

public class ConfirmationPage extends Waits {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='hero-primary']")
	WebElement thankYou;

	@FindBy(xpath = "//table //label[@class='ng-star-inserted']")
	WebElement order;

	public String confirmThankYou() {
		String thanks = thankYou.getText();
		return thanks;
	}

	public void getOrderID() {
		String orderID = order.getText().split(" ")[1].trim();
		System.out.println(orderID);
	}
}
