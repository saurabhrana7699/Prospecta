package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {

	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer entryid;

	
	@JsonProperty("API")
	private String title;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Auth")
	private String auth;
	
	@JsonProperty("Https")
	private boolean https;
	
	@JsonProperty("Cors")
	private String cors;
	
	@JsonProperty("Link")
	private String link;
	
	@JsonProperty("Category")
	private String category;
	
	
	
}
