package com.restapi.book.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.book.entities.Book;
import com.restapi.book.services.BookService;


@RestController
public class BookControllers {
/*
	//@RequestMapping(value="/books", method=RequestMethod.GET)
	//@ResponseBody	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
      public List<Book> getBooks()
      {
//		Book book = new Book();
//		book.setId(12345);
//		book.setAuthor("Swati Arya");
//		book.setTitle("Full Steck Java Book");
		
    	  return this.bookService.getAllBooks();
      }
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}
	// add book Handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b= this.bookService.addBook(book);
		System.out.println(book);
		return book;
	}
	//Delete Book handler
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id)
	{
		this.bookService.deleteBook(id);
	}
	//Update book handler
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id)
	{
		this.bookService.updateBook(id, book);
		return book;
	}
*/
	//****************************how to send http status 
	
	@Autowired
	private BookService bookService;	
	@GetMapping("/books")
      public ResponseEntity<List<Book>> getBooks()
      {	
		 List<Book> list = bookService.getAllBooks();
		 if(list.size()<=0)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
    	  return ResponseEntity.status(HttpStatus.CREATED).body(list);
      }
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id)
	{
		Book book = bookService.getBookById(id);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	// add book Handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		Book b= null;
		try {
		b= this.bookService.addBook(book);
		System.out.println(book);
		return ResponseEntity.of(Optional.of(b));
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	//Delete Book handler
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
	{
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e)
		{
		   e.printStackTrace();
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	//Update book handler
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id)
	{
		try {
			this.bookService.updateBook(id, book);
			return ResponseEntity.ok().body(book);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
