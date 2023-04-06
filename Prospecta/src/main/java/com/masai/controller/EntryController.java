package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.EntryDTO;
import com.masai.entity.Entry;
import com.masai.exception.EntryException;
import com.masai.service.EntryService;

@RestController
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	
	@PostMapping("/entries")
	public ResponseEntity<Entry> saveEntryHandler(){
		Entry en = entryService.saveEntry();	
		return new ResponseEntity<Entry>(en, HttpStatus.OK);
	}
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDTO>> 
	findEntryByCategoryHandler(@PathVariable("category") String category) throws EntryException{
		   List<EntryDTO> list= entryService.getEntryByCategory(category);
		   return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
}
