package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.NewsRepository;
import com.example.demo.scraper.FanaBc;
import com.example.demo.scraper.SeliniumConfig;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private NewsRepository newsRepository;
	
	private FanaBc fanaBc;
	public HomeController() {
		this.fanaBc=new FanaBc(this.newsRepository);
		WebServer driver;
	}
	@GetMapping
	public String getHome() {
		//	this.fanaBc.connect();
		testing();

		return "home";
	}
	public void testing() {
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
