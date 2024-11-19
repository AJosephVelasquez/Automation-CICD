package AlainVelasquez.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AlainVelasquez.AbstractComponents.Waits;

public class CartPage extends Waits {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//li[@class='totalRow']/button")
	WebElement checkoutButton;

	public boolean checkProduct(String desiredProduct) {
		return cartProducts.stream().anyMatch(s -> s.getText().equalsIgnoreCase(desiredProduct));
	}

	public PaymentAndShipping clickCheckout() {
		checkoutButton.click();
		return new PaymentAndShipping(driver);
	}

}
