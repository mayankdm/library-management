package com.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootstarter.models.Librarian;
import com.springbootstarter.repo.LibrarianRepository;

@Service
public class LibrarianService {
	@Autowired
	private LibrarianRepository librarianRepository;
	
	public List<Librarian> getAllLibrarians(){
		List list = new ArrayList<>();
		librarianRepository.findAll().forEach(list::add);
		return list;
	}
	
	public Librarian getLibrarian(Integer id){
		return librarianRepository.findOne(id);
	}

	public void addLibrarian(Librarian librarian) {
		librarianRepository.save(librarian);
	}

	public void updateLibrarian(Librarian librarian) {
		librarianRepository.save(librarian);
	}

	public void deleteLibrarian(Integer id) {
		librarianRepository.delete(id);
	}
}
