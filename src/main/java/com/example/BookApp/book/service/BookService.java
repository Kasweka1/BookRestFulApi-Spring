package com.example.BookApp.book.service;

import java.util.*;
import com.example.BookApp.book.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.BookApp.book.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private  BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
