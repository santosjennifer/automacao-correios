package br.com.correios.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
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

	public void scrollPage() {
		JavascriptExecutor jse = (JavascriptExecutor) browser;
		jse.executeScript("scrollBy(0,250)", "");
	}

	public void closeBrowser() {
		this.browser.quit();
	}

}