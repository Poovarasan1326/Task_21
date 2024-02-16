package task_21;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_Automation {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Open the URL
		driver.get("http://the-internet.herokuapp.com/nested_frames");

		// Switch to the top frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

		// Verify that there are three frames on the page
		int numberOfFrames = driver.findElements(By.cssSelector("frame")).size();
		if (numberOfFrames != 3) {
			System.out.println("Number of frames is not as expected.");
			driver.quit();
			return;
		}

		// Switch to the left frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));

		// Verify that the left frame has a text "LEFT"
		WebElement leftFrameText = driver.findElement(By.tagName("body"));
		if (!leftFrameText.getText().equals("LEFT")) {
			System.out.println("Left frame text is not as expected.");
			driver.quit();
			return;
		}

		// Switch back to the top frame
		driver.switchTo().defaultContent();

		// Switch to the middle frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));

		// Verify that the middle frame has a text "MIDDLE"
		WebElement middleFrameText = driver.findElement(By.tagName("body"));
		if (!middleFrameText.getText().equals("MIDDLE")) {
			System.out.println("Middle frame text is not as expected.");
			driver.quit();
			return;
		}

		// Switch back to the top frame
		driver.switchTo().defaultContent();

		// Switch to the right frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-right']")));

		// Verify that the right frame has a text "RIGHT"
		WebElement rightFrameText = driver.findElement(By.tagName("body"));
		if (!rightFrameText.getText().equals("RIGHT")) {
			System.out.println("Right frame text is not as expected.");
			driver.quit();
			return;
		}

		// Switch back to the top frame
		driver.switchTo().defaultContent();

		// Switch to the bottom frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));

		// Verify that the bottom frame has a text "BOTTOM"
		WebElement bottomFrameText = driver.findElement(By.tagName("body"));
		if (!bottomFrameText.getText().equals("BOTTOM")) {
			System.out.println("Bottom frame text is not as expected.");
			driver.quit();
			return;
		}

		// Switch back to the top frame
		driver.switchTo().defaultContent();

		// Verify that the page title is "Frames"
		String pageTitle = driver.getTitle();
		if (!pageTitle.equals("Frames")) {
			System.out.println("Page title is not as expected.");
		} else {
			System.out.println("All tests passed successfully.");
		}

		// Quit the driver
		driver.quit();
	}

}
