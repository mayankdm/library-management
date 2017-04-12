package com.mayank.springbootstarter.repo;

import org.springframework.data.repository.CrudRepository;

import com.mayank.springbootstarter.models.Library;

public interface LibraryRepository extends CrudRepository<Library, Integer>{

}
