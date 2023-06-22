package allPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webmath.com.base.BaseTest;
import webmath.com.pages.HomePage;

public class HomePageTest extends BaseClass {

	HomePage homePage;

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}

	@Test
	public void validateHomePageTitle() {
		String actualTitle = homePage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, prop.getProperty("expectedTitle"));
	}

	@Test
	public void validateWebMathLogoDispalyed() {
		Assert.assertTrue(homePage.validateWebMathLogo());
	}

	@Test
	public void validateWebMathLogo() {
		String actualLogo = homePage.getLoginPageTitle();
		Assert.assertEquals(actualLogo, prop.getProperty("expectedTitle"));
	}

	@Test
	public void validateSelectedDropdown() {
		homePage.selectTopicByVisibleText(prop.getProperty("helpValue"));
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("item.xpath"))).isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
