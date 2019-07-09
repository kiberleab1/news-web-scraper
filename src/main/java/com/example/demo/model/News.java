package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String newsSource;
	

	private String catagory;
	
	private String link;
	
	//@OneToMany
	///private Images imgofNews;
}
