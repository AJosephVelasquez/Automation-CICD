package AlainVelasquez.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AlainVelasquez.AbstractComponents.DashboardComponents;
import AlainVelasquez.PageObjects.CartPage;
import AlainVelasquez.PageObjects.ConfirmationPage;
import AlainVelasquez.PageObjects.PageOrder;
import AlainVelasquez.PageObjects.PaymentAndShipping;
import AlainVelasquez.PageObjects.ProductDashboard;
import AlainVelasquez.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException {

		ProductDashboard productDashboard = loginPage.loginDetails(input.get("email"), input.get("password"));

		productDashboard.addToCart(input.get("desiredProduct"));
		CartPage cartPage = productDashboard.pressCartButton();

		Boolean match = cartPage.checkProduct(input.get("desiredProduct"));
		Assert.assertTrue(match);
		PaymentAndShipping paymentAndShipping = cartPage.clickCheckout();

		paymentAndShipping.inputCountry("New");
		paymentAndShipping.chooseCountry();
		ConfirmationPage confirmationPage = paymentAndShipping.placeOrder();

		String thanks = confirmationPage.confirmThankYou();
		Assert.assertTrue(thanks.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" }, dataProvider = "getData")
	public void validateOrder(HashMap<String, String> input) {
		loginPage.loginDetails(input.get("email"), input.get("password"));

		DashboardComponents dashboardComponents = new DashboardComponents(driver);
		PageOrder pageOrder = dashboardComponents.clickOrders();
		Boolean match = pageOrder.verifyProductName(input.get("desiredProduct"));
		Assert.assertTrue(match);
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getData(
				System.getProperty("user.dir") + "\\src\\test\\java\\AlainVelasquez\\data\\PurchaseOrder.json");

		int limit = data.size();
		
		Object[][] maps = new Object[limit][1];
		
		for(int i = 0; i < limit; i ++) {
			maps[i][0] = data.get(i);
		}
		
		return maps;
	}

}

//		return new Object[][] {
//			{"viktormagnus@gmail.com", "Password123", "ZARA COAT 3"},
//			{"magnusviktor@gmail.com", "Password123", "ADIDAS ORIGINAL"}
//		};

//		HashMap<String, String> map = new HashMap<>();
//		map.put("email", "viktormagnus@gmail.com");
//		map.put("password", "Password123");
//		map.put("desiredProduct", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<>();
//		map1.put("email", "magnusviktor@gmail.com");
//		map1.put("password", "Password123");
//		map1.put("desiredProduct", "ADIDAS ORIGINAL");
