package com.example.BookApp.book.repository;

import com.example.BookApp.book.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, String> {

    @Query("SELECT COUNT(v) FROM Venue v WHERE v.venueName = ?1")
    Long countVenuesByName(String venueName);

    @Query("SELECT v FROM Venue v WHERE v.venueName LIKE %?1%")
    List<Venue> findVenuesByNameContaining(String name);
}
