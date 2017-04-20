package com.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootstarter.models.Book;
import com.springbootstarter.models.Library;
import com.springbootstarter.services.BookService;
import com.springbootstarter.services.LibraryService;

@RestController
public class LibraryController {
	@Autowired
	public LibraryService libraryService;

	@Autowired
	public BookService bookService;

	@RequestMapping("/libraries")
	public List<Library> getAllLibrarys() {
		return libraryService.getAllLibraries();
	}

	@RequestMapping("/libraries/{value}")
	public Library getLibrary(@PathVariable String value) {
		int id = 0;
		boolean success = true;
		try {
			id = Integer.parseInt(value);
		} catch (Exception e) {
			success = false;
		}
		if(success){
			return libraryService.getLibrary(id);
		}else{
			return libraryService.getLibraryByName(value);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/libraries")
	public String addLibrary(@RequestBody Library library) {
		libraryService.addLibrary(library);
		return "Library Created Successfully!";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/libraries")
	public String updateLibrary(@RequestBody Library library) {
		libraryService.updateLibrary(library);
		return "Library updated successfully!";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/libraries/{value}")
	public String deleteLibrary(@PathVariable String value) {
		int id = 0;
		boolean success = true;
		try {
			id = Integer.parseInt(value);
		} catch (Exception e) {
			success = false;
		}
		if(success){
			libraryService.deleteLibrary(id);
		}else{
			libraryService.deleteLibraryByName(value);
		}
		return "Library deleted successfully!";
	}

	@RequestMapping("/libraries/{id}/books")
	public List<Book> getBooksByLibrary(@PathVariable Integer id) {
		return bookService.getAllBooksByLibrary(id);
	}
}
