package com.masai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.DTO.AllEntryDTO;
import com.masai.DTO.EntryDTO;
import com.masai.entity.Entry;
import com.masai.exception.EntryException;
import com.masai.repository.EntryRepo;

@Service
public class EntryServiceImpl implements EntryService {
	
	
	 @Autowired
	    private EntryRepo entryRepo;
	 

	    @Autowired
	    private RestTemplate  restTemplate;
	    

	@Override
	public List<EntryDTO> getEntryByCategory(String category) throws EntryException {
		
		String url = "https://api.publicapis.org/entries";
		
		ResponseEntity<AllEntryDTO> responseEntity = 
				restTemplate.getForEntity(url, AllEntryDTO.class);
		
		System.out.println(responseEntity.getBody().getEntries());
		
		List<EntryDTO> list = new ArrayList<>();
		
		for(Entry e : responseEntity.getBody().getEntries()) {
			if(category.equals(e.getCategory())) {
				list.add(new EntryDTO(e.getTitle(),e.getDescription()));
			}
			System.out.println(list);
		}
		
		if(list.size()==0)
			  throw new EntryException(" Entry  Not  found  with  These category : "+ category);
		
		return list;
	}

	
	@Override
	public Entry saveEntry() {
	String url = "https://api.publicapis.org/random";
	
	ResponseEntity<AllEntryDTO> responseEntity  = restTemplate.getForEntity(url, AllEntryDTO.class);
	
	Entry entry = responseEntity.getBody().getEntries().get(0);
	
	return entryRepo.save(entry);

	}

}
