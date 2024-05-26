package com.example.BookApp.book.repository;

import com.example.BookApp.user.model.User;
import com.example.BookApp.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByUser(User user);
   
    @Query("SELECT COUNT(b) FROM Book b WHERE b.genre = 'Horror'")
    Long countBooksByHorrorGenre();
    @Query("SELECT COUNT(b) FROM Book b WHERE b.genre = 'Comedy'")
    Long countBooksByComedyGenre();
    @Query("SELECT COUNT(b) FROM Book b WHERE b.genre = 'Fantasy'")
    Long countBooksByFantasyGenre();
    @Query("SELECT COUNT(b) FROM Book b WHERE b.genre = 'Fiction'")
    Long countBooksByFictionGenre();
}

