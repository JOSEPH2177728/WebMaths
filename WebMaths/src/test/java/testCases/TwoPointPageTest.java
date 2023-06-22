package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webmath.com.base.BaseTest;
import webmath.com.pages.HomePage;
import webmath.com.pages.PlotGeometryPage;
import webmath.com.pages.TwoPointPage;

public class TwoPointPageTest extends BaseClass {
	
	HomePage homePage;
	PlotGeometryPage plotGeometryPage;
	TwoPointPage twoPointPage;

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		plotGeometryPage = new PlotGeometryPage();
		twoPointPage = new TwoPointPage();
	}
	
	@Test
	public void fillInThePoints() {
		homePage.clickOnPlotGeometry();
		plotGeometryPage.clickOnTwoPoint();
		twoPointPage.enterPoint1(prop.getProperty("x1input"), prop.getProperty("y1input"));
		twoPointPage.enterPoint2(prop.getProperty("x2input"), prop.getProperty("y2input"));
		twoPointPage.submitForm();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
