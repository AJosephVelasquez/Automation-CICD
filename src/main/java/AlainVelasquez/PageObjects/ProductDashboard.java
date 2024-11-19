package AlainVelasquez.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AlainVelasquez.AbstractComponents.DashboardComponents;
import AlainVelasquez.AbstractComponents.Waits;

public class ProductDashboard extends Waits {

	WebDriver driver;

	public ProductDashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "toast-container")
	WebElement greenAlert;

	@FindBy(xpath = "//div[@class='card-body']")
	List<WebElement> products;

	@FindBy(tagName = "ngx-spinner")
	WebElement loadSpinner;

	public void addToCart(String desiredProduct) {

		invisibilityOf(greenAlert);

		for (WebElement product : products) {
			if (product.findElement(By.xpath(".//b")).getText().equalsIgnoreCase(desiredProduct)) {
				product.findElement(By.xpath(".//button[contains(text(), 'Cart')]")).click();
				break;
			}
		}

//		WebElement prod = products.stream().filter(s -> s.findElement(By.xpath("//h5")).getText().equalsIgnoreCase(desiredProduct)).findFirst().orElse(null);
//		prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();

		invisibilityOf(loadSpinner);
		invisibilityOf(greenAlert);
	}

	public CartPage pressCartButton() {
		DashboardComponents dashboardComponents = new DashboardComponents(driver);
		dashboardComponents.clickCart();
		return new CartPage(driver);
	}

}
