package com.springbootstarter.controller;


import java.time.LocalDate;
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
	
	@RequestMapping(value={"/books"})
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/books/{value}")
	public Book getBookById(@PathVariable String value){
		int id = 0;
		boolean success = true;
		try{
			id = Integer.parseInt(value);
		}catch (Exception e) {
			success = false;
		}
		if(success){
			return bookService.getBook(id);
		}else{
			return bookService.getBookByName(value);
		}
	}
	
	@RequestMapping("{author}/books")
	public List<Book> getBookByAuthor(@PathVariable String author){
		return bookService.getBookByAuthorName(author);
	}
	
	@RequestMapping("/librarians/{roll}/books")
	public List<Book> getBookByLibrarian(@PathVariable Integer roll){
		return bookService.getBookByLibrarian(roll);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/books")
	public String addBook(@RequestBody Book book){
		bookService.addBook(book);
		return "Book created successfully!";
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/books")
	public String updateBook(@RequestBody Book book){
		bookService.updateBook(book);
		return "Book updated successfully!";
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/books/{id}")
	public String updateBook(@RequestBody LinkedHashMap<String, Integer> book,@PathVariable Integer id){
		Librarian librarian = librarianService.getLibrarian(book.get("roll")); 
		Book _newBook = bookService.getBook(id);
		_newBook.setLibrarian(librarian);
		_newBook.setIssueDate(LocalDate.now());
		bookService.updateBook(_newBook);
		return "Book updated successfully!";
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/books/{value}")
	public String deleteBook(@RequestBody Book book, @PathVariable String value){
		int id = 0;
		boolean success = true;
		try {
			id = Integer.parseInt(value);
		} catch (Exception e) {
			success = false;
		}
		if(success){
			bookService.deleteBook(id);
		}else{
			bookService.deleteByName(value);
		}
		return "Book deleted successfully!";
	}
}
