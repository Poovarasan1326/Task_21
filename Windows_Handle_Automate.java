package task_21;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.Set;

public class Windows_Handle_Automate {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://the-internet.herokuapp.com/windows");

		// Find and click the "Click Here" button
		WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
		clickHereButton.click();

		// Get handles of all open windows
		Set<String> windowHandles = driver.getWindowHandles();

		// Switch to the new window
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Verify that the text "New Window" is present on the page
		String pageSource = driver.getPageSource();
		if (pageSource.contains("New Window")) {
			System.out.println("Text 'New Window' is present on the page.");
		} else {
			System.out.println("Text 'New Window' is not present on the page.");
		}

		// Close the new window
		driver.close();

		// Switch back to the original window
		driver.switchTo().window((String) windowHandles.toArray()[0]);

		// Verify that the original window is active
		if (driver.getTitle().equals("The Internet")) {
			System.out.println("Original window is active.");
		} else {
			System.out.println("Original window is not active.");
		}

		// Close the browser instance
		driver.quit();
	}
}
