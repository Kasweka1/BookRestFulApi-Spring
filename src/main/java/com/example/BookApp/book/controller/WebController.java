package com.example.BookApp.book.controller;

import java.util.List;
import java.util.Optional;
import java.util.Map;


import org.springframework.ui.Model;
import com.example.BookApp.book.model.Book;
import org.springframework.stereotype.Controller;
import com.example.BookApp.book.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class WebController {
    

    private final BookService bookService;

    @Autowired
    public  WebController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {

        Long bookCount = bookService.getBookCount();
        model.addAttribute("bookCount", bookCount);
        // You can add more attributes to the model if needed for the dashboard
        Long horrorBookCount = bookService.getCountOfHorrorBooks();
        Long comedyBookCount = bookService.getCountOfComedyBooks();
        Long fantasyBookCount = bookService.getCountOfFantasyBooks();
        Long fictionBookCount = bookService.getCountOfFictionBooks();
        model.addAttribute("horrorBookCount", horrorBookCount);
        model.addAttribute("comedyBookCount", comedyBookCount);
        model.addAttribute("fantasyBookCount", fantasyBookCount);
        model.addAttribute("fictionBookCount", fictionBookCount);

        return "dashboard"; 
    }

    @GetMapping
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);


        return "books";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model){
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "book-details";
        } else {
            return "not-found";
        }
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "edit-book";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        book.setId(id);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }


    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "delete-book";
        } else {
            return "not-found";
        }
    }

    
}
