package AlainVelasquez.StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import AlainVelasquez.PageObjects.CartPage;
import AlainVelasquez.PageObjects.ConfirmationPage;
import AlainVelasquez.PageObjects.PaymentAndShipping;
import AlainVelasquez.PageObjects.ProductDashboard;
import AlainVelasquez.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {

	public ProductDashboard productDashboard;
	public CartPage cartPage;
	public PaymentAndShipping paymentAndShipping;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce page")
	public void landingOnEcommercePage() throws IOException {
		launchPage();
	}

	@Given("^that the user is logged in with email (.+) and password (.+)$")
	public void logginIn(String email, String password) {
		productDashboard = loginPage.loginDetails(email, password);
	}

	@When("^user adds product (.+) to his Cart$")
	public void addToCart(String desiredProduct) {
		productDashboard.addToCart(desiredProduct);
	}

	@When("^checks out with (.+)$")
	public void checkoutProduct(String desiredProduct) {
		cartPage = productDashboard.pressCartButton();

		Boolean match = cartPage.checkProduct(desiredProduct);
		Assert.assertTrue(match);
		paymentAndShipping = cartPage.clickCheckout();
	}
	
	@When("submits the order")
	public void submitTheOrder() {
		paymentAndShipping.inputCountry("New");
		paymentAndShipping.chooseCountry();
		confirmationPage = paymentAndShipping.placeOrder();
	}
	
	@Then("{string} message is displayed on Confirmation Page.") 
	public void confirmPage(String message) {
		String thanks = confirmationPage.confirmThankYou();
		Assert.assertTrue(thanks.equalsIgnoreCase(message));
		driver.quit();
	}
}
