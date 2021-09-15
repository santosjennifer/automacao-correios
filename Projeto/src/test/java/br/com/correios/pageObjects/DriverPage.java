package br.com.correios.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPage {
	
	protected WebDriver browser;
	
	public DriverPage(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		if (browser == null) {
			this.browser = new ChromeDriver();					
		} else {
			this.browser = browser;
		}
		this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.browser.manage().window().maximize();
	}
	
	public void fecharNavegador() {
		this.browser.quit();
	}
	
}