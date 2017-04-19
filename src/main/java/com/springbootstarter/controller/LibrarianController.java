package com.springbootstarter.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootstarter.models.Librarian;
import com.springbootstarter.models.Library;
import com.springbootstarter.services.LibrarianService;
import com.springbootstarter.services.LibraryService;

@RestController
public class LibrarianController {
	@Autowired
	public LibrarianService librarianService;
	
	@Autowired
	public LibraryService libraryService;
	
	@RequestMapping("/librarians")
	public List<Librarian> getAllLibrarians() {
		return librarianService.getAllLibrarians();
	}
	
	@RequestMapping("/librarians/{id}")
	public Librarian getLibrarian(@PathVariable Integer id){
		return librarianService.getLibrarian(id);
	}
	
	@RequestMapping("/libraries/{id}/librarians")
	public List<Librarian> getLibrariansByLibrary(@PathVariable Integer id){
		return librarianService.getLibrariansByLibrary(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/librarians")
	public void addLibrarian(@RequestBody Librarian librarian){
		librarianService.addLibrarian(librarian);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/librarians")
	public void updateLibrarian(@RequestBody Librarian librarian){
		librarianService.updateLibrarian(librarian);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/librarians/{id}")
	public void updateBook(@RequestBody LinkedHashMap<String, Integer> lib,@PathVariable Integer id){
		Library library = libraryService.getLibrary(lib.get("id")); 
		Librarian _newLibrarian = librarianService.getLibrarian(id);
		_newLibrarian.setLibrary(library);
		librarianService.updateLibrarian(_newLibrarian);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/librarians/{id}")
	public void deleteLibrarian(@RequestBody Librarian librarian, @PathVariable Integer id){
		librarianService.deleteLibrarian(id);
	}
}
