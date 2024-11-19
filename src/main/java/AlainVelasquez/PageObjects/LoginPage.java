package AlainVelasquez.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AlainVelasquez.AbstractComponents.Waits;

public class LoginPage extends Waits {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement email;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@role='alert'][contains(@class, 'ng-star-inserted')]")
	WebElement errorMessage;
	
	public String getErrorMessage() {
		visibilityOf(errorMessage);
		return errorMessage.getText();
	}

	public ProductDashboard loginDetails(String userEmail, String userPassword) {
		email.sendKeys(userEmail);
		password.sendKeys(userPassword);
		loginButton.click();
		return new ProductDashboard(driver);
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
