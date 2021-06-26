package br.ce.brlorena.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {
		
	}
	
	public static WebDriver getDriver() {
		if(driver == null) { //Instancia o driver apenas se for null
			switch (Propriedades.browser) {
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().setSize(new Dimension(1200,765));
		}
		
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) { //Apenas executa o quit se o driver não for null
			getDriver().quit();
			driver = null; // volta a ser null
		}
	}
}
