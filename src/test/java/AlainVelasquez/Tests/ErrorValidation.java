package AlainVelasquez.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import AlainVelasquez.PageObjects.CartPage;
import AlainVelasquez.PageObjects.ProductDashboard;
import AlainVelasquez.TestComponents.BaseTest;
import AlainVelasquez.TestComponents.Retry;

public class ErrorValidation extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
	public void invalidLogin() {
		loginPage.loginDetails("viktormagnus@gmail.com", "Password1234");
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
	}

	@Test
	public void invalidProduct() {
		String desiredProduct = "ZARA COAT 3";

		ProductDashboard productDashboard = loginPage.loginDetails("viktormagnus@gmail.com", "Password123");

		productDashboard.addToCart(desiredProduct);
		CartPage cartPage = productDashboard.pressCartButton();

		Boolean match = cartPage.checkProduct("ZARA COAT 33");
		Assert.assertFalse(match);
	}

}
