package allPages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		String mathHelpItem = "cmoney1.html";
		String helpItem = "Coins, Counting";

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.get("https://webmath.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Verify the URL title
		String title = driver.getTitle();
		System.out.println(title); // WebMath - Solve Your Math Problem

		String actualTitle = "WebMath - Solve Your Math Problem";
		Assert.assertEquals(title, actualTitle);

		// Verify the WebMath logo
		boolean logo = driver.findElement(By.xpath("//img[@alt='WebMath - Solve your math problem today']"))
				.isDisplayed();
		Assert.assertTrue(logo);

		// Verify the homepage text

		String hompePageText = driver.findElement(By.cssSelector("div[class='d-homeCopyRow'] h1")).getText();
		System.out.println(hompePageText);
		String actualHomePageText = "Welcome to Webmath!";
		Assert.assertEquals(hompePageText, actualHomePageText);

		// Click on Plots & Geometry
	//	driver.findElement(By.cssSelector("a[title='Plots and Geometry']")).click();

		Select select = new Select(driver.findElement(By.cssSelector("#topicItem")));

		select.selectByValue("diff.html");

		// *[@id="topicItem"]/option[5]
		// option[@value="cmoney1.html"]
		// select.selectByValue("cmoney1.html");
		// select.selectByVisibleText(helpItem);

		driver.findElement(By.cssSelector("a[href='equline1.html']")).click();

		String text = "12345612222";
		WebElement inputBox = driver.findElement(By.cssSelector("input[name='x1']"));
		String restrictedText = text.substring(0, Math.min(text.length(), 5));
		inputBox.sendKeys(restrictedText);

		/*
		 * WebElement dropDownEle =
		 * driver.findElement(By.xpath("//option[@value='cmoney1.html']"));
		 * Assert.assertTrue(dropDownEle.isSelected());
		 * 
		 * List<WebElement> items = select.getOptions(); for (WebElement item : items) {
		 * // System.out.println(item.getText()); if
		 * (item.getText().equals(mathHelpItem)) { item.click(); break; }
		 * 
		 * // Fractions, Subtracting }
		 */
		// option.selectByIndex(5);

	}

}
