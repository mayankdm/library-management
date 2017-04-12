package com.mayank.springbootstarter.repo;

import org.springframework.data.repository.CrudRepository;

import com.mayank.springbootstarter.models.Librarian;

public interface LibrarianRepository extends CrudRepository<Librarian, Integer>{

}
