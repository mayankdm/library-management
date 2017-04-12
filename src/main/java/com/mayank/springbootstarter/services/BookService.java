package com.mayank.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.springbootstarter.models.Book;
import com.mayank.springbootstarter.repo.BookRepository;

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
}
