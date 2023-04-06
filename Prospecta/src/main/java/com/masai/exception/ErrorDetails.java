package com.masai.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

	
	private String message;
	
	private String description;
	
	private LocalDate localdatetime;
}
