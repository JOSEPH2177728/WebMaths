package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadPropertyFile {

	public static WebDriver driver;
	public static Properties prop;

	public static void loadPropertyFile() {
		FileInputStream fis;
		String configFilePath = "D:\\ProjectOnSelenium\\WebMaths\\src\\test\\resources\\configFiles\\config.properties";
		try {
			fis = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("url"));

	}
}
