package com.mayank.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.springbootstarter.models.Librarian;
import com.mayank.springbootstarter.services.LibrarianService;

@RestController
public class LibrarianController {
	@Autowired
	public LibrarianService librarianService;
	
	@RequestMapping("/librarians")
	public List<Librarian> getAllLibrarians() {
		return librarianService.getAllLibrarians();
	}
	
	@RequestMapping("/librarians/{id}")
	public Librarian getLibrarian(@PathVariable Integer id){
		return librarianService.getLibrarian(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/librarians")
	public void addLibrarian(@RequestBody Librarian librarian){
		librarianService.addLibrarian(librarian);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/librarians")
	public void updateLibrarian(@RequestBody Librarian librarian){
		librarianService.updateLibrarian(librarian);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/librarians/{id}")
	public void deleteLibrarian(@RequestBody Librarian librarian, @PathVariable Integer id){
		librarianService.deleteLibrarian(id);
	}
}
