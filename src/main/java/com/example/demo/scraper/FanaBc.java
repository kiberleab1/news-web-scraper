package com.example.demo.scraper;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.NewsRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class FanaBc {
	private String url="https://www.fanabc.com";
	private NewsRepository newsReposioty;

    public static final Logger LOGGER = LoggerFactory.getLogger(FanaBc.class);

	//@Autowired
	public FanaBc(NewsRepository newsReposioty) {
		this.newsReposioty = newsReposioty;
	}
	public void connect() throws IOException {
		Connection connection=Jsoup.connect(url);
		Document doc=connection.get();
		Elements elements=doc.getElementsByClass("row-2");
		for (Element element : elements) {
		 //element.data()
				LOGGER.info(element.data());
		

		}
	}
}
