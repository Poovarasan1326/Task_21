package task_21;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe_Automate {

	public static void main(String[] args) {

		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://the-internet.herokuapp.com/iframe");

		// Switch to the iframe
		driver.switchTo().frame("mce_0_ifr"); // You can also locate the iframe by its index or any other suitable
												// method

		// Locate the "p" tag inside the iframe and write the text "Hello People"
		WebElement paragraph = driver.findElement(By.tagName("p"));
		paragraph.clear(); // Clear any existing text
		paragraph.sendKeys("Hello People");

		// Switch back to the main content
		driver.switchTo().defaultContent();

		// Close the browser instance
		driver.quit();
	}
}
