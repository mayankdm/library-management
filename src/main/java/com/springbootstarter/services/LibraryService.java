package com.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootstarter.models.Library;
import com.springbootstarter.repo.LibraryRepository;

@Service
public class LibraryService {
	@Autowired
	private LibraryRepository libraryRepository;
	
	public List<Library> getAllLibraries(){
		List list = new ArrayList<>();
		libraryRepository.findAll().forEach(list::add);
		return list;
	}
	
	public Library getLibrary(Integer id){
		return libraryRepository.findOne(id);
	}

	public void addLibrary(Library library) {
		libraryRepository.save(library);
	}

	public void updateLibrary(Library library) {
		libraryRepository.save(library);
	}

	public void deleteLibrary(Integer id) {
		libraryRepository.delete(id);
	}
}
