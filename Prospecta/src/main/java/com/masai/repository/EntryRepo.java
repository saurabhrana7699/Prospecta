package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.DTO.EntryDTO;
import com.masai.entity.Entry;

public interface EntryRepo extends JpaRepository<Entry, Integer>  {

	 public List<EntryDTO> findByCategory(String category);

}
