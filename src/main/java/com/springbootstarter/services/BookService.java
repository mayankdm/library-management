package com.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootstarter.models.Book;
import com.springbootstarter.repo.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		List list = new ArrayList<>();
		bookRepository.findAll().forEach(list::add);
		return list;
	}
	
	public Book getBook(Integer id){
		return bookRepository.findOne(id);
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(Integer id) {
		bookRepository.delete(id);
	}

	public List<Book> getAllBooksByLibrary(Integer id) {
		return bookRepository.findByLibraryLibraryId(id);
	}

	public List<Book> getBookByLibrarian(Integer roll) {
		return bookRepository.findByLibrarianRoll(roll);
	}

	public List<Book> getBookByAuthorName(String author) {
		
		return bookRepository.findByAuthor(author);
	}

	public Book getBookByName(String name) {
		return bookRepository.findByName(name);
	}

	public int deleteByName(String value) {
		return bookRepository.deleteByName(value);
	}
}
