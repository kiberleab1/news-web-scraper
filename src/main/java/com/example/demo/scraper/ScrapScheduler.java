package com.example.demo.scraper;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScrapScheduler {
	@Scheduled(fixedRate=2000)
	public void ScrapFana() {
		SeliniumConfig config=new SeliniumConfig();
		WebDriver driver=config.getDriver();
		  String appUrl = "https://portal.aait.edu.et";
	        driver.get(appUrl);
	        String title = driver.getTitle();
	        System.out.println(title);
	        driver.findElement(By.name("UserName")).sendKeys("ATR/6688/09");
	        driver.findElement(By.id("Password")).sendKeys("7848");
	        driver.findElement(By.className("btn-success")).click();
	        String reportUrl = driver.findElement(By.id("m2")).findElement(By.className("dropdown-menu")).findElements(By.tagName("li")).get(0).findElements(By.tagName("a")).get(0).getAttribute("href");
	        driver.navigate().to(reportUrl);
	        String table = driver.findElement(By.className("table")).getText();
	        System.out.println(table);
	        PrintWriter writer;
			try {
				writer = new PrintWriter("gradeReport", "UTF-8");
				 writer.print(table);
			        writer.close();
			        Thread.sleep(5000);
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        driver.quit();
	        System.out.println("Finished");
	}
}
