package com.springbootstarter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootstarter.models.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public List<Book> findByLibraryLibraryId(Integer id);
	public List<Book> findByLibrarianRoll(Integer roll);
	public List<Book> findByAuthor(String author);
	public Book findByName(String name);
	
	@Modifying
	@Transactional
	@Query("Delete FROM Book b WHERE b.name = ?1")
	public int deleteByName(String value);
}
