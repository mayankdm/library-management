package com.springbootstarter.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springbootstarter.models.Librarian;

public interface LibrarianRepository extends CrudRepository<Librarian, Integer>{

	List<Librarian> findByLibraryLibraryId(Integer id);

}
