package com.example.demo.scraper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeliniumConfig {
	private WebDriver driver;
	
	public SeliniumConfig() {
		Capabilities capabilities=DesiredCapabilities.firefox();
		driver=new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	static {
		System.setProperty("webdriver.gecko.driver", "/home/eniyew/Documents/drivers/geckodriver");
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void closedWindow() {
		this.driver.close();
	}
}
