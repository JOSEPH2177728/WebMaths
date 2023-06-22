package allPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webmath.com.base.BaseTest;
import webmath.com.pages.HomePage;
import webmath.com.pages.PlotGeometryPage;

public class PlotGeometryPageTest extends BaseClass {
	
	HomePage homePage;
	PlotGeometryPage plotGeometryPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		plotGeometryPage = new PlotGeometryPage();
	}
	
	@Test
	public void validatePlotGeometryText() {
		homePage.clickOnPlotGeometry();
		String actualPlotGeometryText = plotGeometryPage.getplotGeometryText();
		Assert.assertEquals(actualPlotGeometryText, prop.getProperty("expectedPlotGeometryText"));
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
