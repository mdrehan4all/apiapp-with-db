package com.apiapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.apiapp.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
