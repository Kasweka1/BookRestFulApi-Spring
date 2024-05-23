package com.example.BookApp.book.repository;


import com.example.BookApp.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

   
    @Query("SELECT COUNT(b) FROM Book b WHERE b.genre = 'Horror'")
    Long countBooksByHorrorGenre();
    @Query("SELECT COUNT(b) FROM Book b WHERE b.genre = 'Comedy'")
    Long countBooksByComedyGenre();
    @Query("SELECT COUNT(b) FROM Book b WHERE b.genre = 'Fantasy'")
    Long countBooksByFantasyGenre();
    @Query("SELECT COUNT(b) FROM Book b WHERE b.genre = 'Fiction'")
    Long countBooksByFictionGenre();
}

