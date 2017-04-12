package com.mayank.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.springbootstarter.models.Library;
import com.mayank.springbootstarter.services.LibraryService;

@RestController
public class LibraryController {
	@Autowired
	public LibraryService libraryService;
	
	@RequestMapping("/libraries")
	public List<Library> getAllLibrarys() {
		return libraryService.getAllLibraries();
	}
	
	@RequestMapping("/libraries/{id}")
	public Library getLibrary(@PathVariable Integer id){
		return libraryService.getLibrary(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/libraries")
	public void addLibrary(@RequestBody Library library){
		libraryService.addLibrary(library);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/libraries")
	public void updateLibrary(@RequestBody Library library){
		libraryService.updateLibrary(library);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/libraries/{id}")
	public void deleteLibrary(@RequestBody Library library, @PathVariable Integer id){
		libraryService.deleteLibrary(id);
	}
}
