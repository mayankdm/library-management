package com.springbootstarter.controller;

import java.time.LocalDate;
import java.util.Date;
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
public class BookController {
	@Autowired
	public BookService bookService;
	@Autowired
	public LibrarianService librarianService;
	@Autowired
	public LibraryService libraryService;
	
	@RequestMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/books/{id}")
	public Book getBook(@PathVariable Integer id){
		return bookService.getBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/books")
	public void addBook(@RequestBody Book book){
		bookService.addBook(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/books")
	public void updateBook(@RequestBody Book book){
		Librarian librarian = librarianService.getLibrarian(book.getLibrarian().getRoll());
		Library library = libraryService.getLibrary(book.getLibrary().getLibraryId());
		book.setLibrarian(librarian);
		book.setLibrary(library);
		book.setIssueDate(new Date());
		bookService.updateBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/books/{id}")
	public void deleteBook(@RequestBody Book book, @PathVariable Integer id){
		bookService.deleteBook(id);
	}
}
