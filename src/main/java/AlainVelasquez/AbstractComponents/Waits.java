package AlainVelasquez.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public Waits(WebDriver driver) {
		this.driver = driver;
	}

	public void invisibilityOf(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void visibilityOf(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
