package com.springbootstarter.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springbootstarter.models.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public List<Book> findByLibraryLibraryId(Integer id);
	public List<Book> findByLibrarianRoll(Integer roll);
	public List<Book> findByAuthor(String author);
}
