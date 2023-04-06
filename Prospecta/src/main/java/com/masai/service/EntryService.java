package com.masai.service;

import java.util.List;

import com.masai.DTO.EntryDTO;
import com.masai.entity.Entry;
import com.masai.exception.EntryException;

public interface EntryService {
	
	 public List<EntryDTO> getEntryByCategory(String category) throws EntryException ;

	   public Entry saveEntry();
	   
}
