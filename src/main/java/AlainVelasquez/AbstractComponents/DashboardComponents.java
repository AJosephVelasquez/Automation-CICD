package AlainVelasquez.AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AlainVelasquez.PageObjects.PageOrder;
import AlainVelasquez.PageObjects.ProductDashboard;

public class DashboardComponents {

	WebDriver driver;

	public DashboardComponents(WebDriver driver) {
		if (driver == null) {
            throw new IllegalStateException("Driver is null when initializing DashboardComponents");
        }
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/']")
	WebElement homeButton;

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement ordersButton;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;

	@FindBy(xpath = "//button[contains(text(), 'Sign Out')]")
	WebElement signOutButton;

	public ProductDashboard clickHome() {
		homeButton.click();
		return new ProductDashboard(driver);
	}

	public PageOrder clickOrders() {
		ordersButton.click();
		return new PageOrder(driver);
	}

	public void clickCart() {
		cartButton.click();
	}

	public void clickSignOut() {
		signOutButton.click();
	}

}
