package com.mayank.springbootstarter.repo;

import org.springframework.data.repository.CrudRepository;

import com.mayank.springbootstarter.models.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	//public List<Course> findByTopicId(String topicId);
}
