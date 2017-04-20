package com.springbootstarter.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootstarter.models.Book;
import com.springbootstarter.models.Librarian;
import com.springbootstarter.models.Library;
import com.springbootstarter.services.BookService;
import com.springbootstarter.services.LibrarianService;
import com.springbootstarter.services.LibraryService;

@RestController
public class LibrarianController {
	@Autowired
	public LibrarianService librarianService;
	
	@Autowired
	public LibraryService libraryService;
	
	@Autowired
	public BookService bookService;
	
	@RequestMapping("/librarians")
	public List<Librarian> getAllLibrarians() {
		return librarianService.getAllLibrarians();
	}
	
	@RequestMapping("/librarians/{value}")
	public Librarian getLibrarian(@PathVariable String value){
		int id = 0;
		boolean success = true;
		try {
			id = Integer.parseInt(value);
		} catch (Exception e) {
			success = false;
		}
		if(success){
			return librarianService.getLibrarian(id);
		}else{
			return librarianService.getLibrarianByName(value);
		}
	}
	
	@RequestMapping("/libraries/{id}/librarians")
	public List<Librarian> getLibrariansByLibrary(@PathVariable Integer id){
		return librarianService.getLibrariansByLibrary(id);
	}
	@RequestMapping("/books/{id}/librarians")
	public List<Librarian> getLibrariansByBook(@PathVariable Integer id){
		return librarianService.getLibrariansByBook(id);
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
		Library library = libraryService.getLibrary(lib.get("libraryId")); 
		Book book = bookService.getBook(lib.get("bookId"));
		Librarian _newLibrarian = librarianService.getLibrarian(id);
		_newLibrarian.setLibrary(library);
		_newLibrarian.setBook(book);
		librarianService.updateLibrarian(_newLibrarian);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/librarians/{id}")
	public void deleteLibrarian(@RequestBody Librarian librarian, @PathVariable Integer id){
		librarianService.deleteLibrarian(id);
	}
}
