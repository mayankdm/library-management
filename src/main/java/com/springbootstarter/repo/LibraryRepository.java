package com.springbootstarter.repo;

import org.springframework.data.repository.CrudRepository;

import com.springbootstarter.models.Library;

public interface LibraryRepository extends CrudRepository<Library, Integer>{

}
