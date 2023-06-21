package com.restapi.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.book.dao.BookRepository;
import com.restapi.book.entities.Book;
@Component
public class BookService {
//	private static List<Book> list = new ArrayList<>();
//	static
//	{
//		list.add(new Book(123,"Full Stack Java", "Swati Arya"));
//		list.add(new Book(124,"Python Course", "Kartik"));
//		list.add(new Book(125,"JavaScript Course", "Ravi"));
//		list.add(new Book(126,"MongoDb Course", "Sourav"));
//	}
	@Autowired
	private BookRepository bookRepository;
	//get all books
	public List<Book> getAllBooks()
	{
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id)
	{
		Book book=null;
		try {
		//book = list.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.bookRepository.findById(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
    
	// Add book
	public Book addBook(Book book)
	{
		//list.add(book);
		Book result = bookRepository.save(book);
		return result;
	}
	// Delete Book
	public void deleteBook(int bid)
	{
		//list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	
	}
	//Update book
	public void updateBook(int id, Book book)
	{
//		list = list.stream().map(b->{
//			if(b.getId()==id)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		bookRepository.save(book);	
	}
}
