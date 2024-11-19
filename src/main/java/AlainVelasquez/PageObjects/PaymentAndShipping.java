package AlainVelasquez.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AlainVelasquez.AbstractComponents.Waits;

public class PaymentAndShipping extends Waits {

	WebDriver driver;

	public PaymentAndShipping(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='input txt text-validated' and @placeholder='Select Country']")
	WebElement countryAutoSuggest;

	@FindBy(xpath = "//section[contains(@class,'star-inserted')]")
	WebElement autoSuggDropdown;

	@FindBy(xpath = "//button[contains(@class, 'ta-item')]/span")
	List<WebElement> countrySelection;

	@FindBy(xpath = "//div[@class='actions']/a")
	WebElement placeOrderButton;

	public void inputCountry(String country) {
		countryAutoSuggest.sendKeys(country);
	}

	public void chooseCountry() {
		visibilityOf(autoSuggDropdown);
		WebElement country = countrySelection.stream().findFirst().orElse(null);
		country.click();
	}

	public ConfirmationPage placeOrder() {
		placeOrderButton.click();
		return new ConfirmationPage(driver);
	}

}
