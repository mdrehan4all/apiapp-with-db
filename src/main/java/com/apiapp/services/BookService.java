package com.apiapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.apiapp.dao.BookRepository;
import com.apiapp.entities.Book;

@Component
public class BookService {

	private static List<Book> list=new ArrayList<>();
	
	/*static {
		list.add(new Book(1, "MyBook 1", "ABC 1"));
		list.add(new Book(2, "MyBook 2", "ABC 2"));
		list.add(new Book(3, "MyBook 3", "ABC 3"));
	}*/
	
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	public Book getBookById(int id) {
		//return list.stream().filter(e->e.getId()==id).findFirst().get();
		return this.bookRepository.findById(id);
	}
	
	public Book addBook(Book b) {
		//list.add(b);
		//return b;
		Book result = this.bookRepository.save(b);
		return result;
	}
	
	public void deleteBook(int id) {
		//list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
		this.bookRepository.deleteById(id);
	}
	
	public void updateBook(Book b, int id) {
		/*
		list = list.stream().map(book->{
			if(book.getId()==id) {
				book.setTitle(b.getTitle());
				book.setAuthor(b.getAuthor());
			}
			return book;
		}).collect(Collectors.toList());
		return list;
		*/
		b.setId(id);
		this.bookRepository.save(b);
	}
}
