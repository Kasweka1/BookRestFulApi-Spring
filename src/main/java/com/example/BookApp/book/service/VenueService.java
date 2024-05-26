package com.example.BookApp.book.service;

import com.example.BookApp.book.model.Venue;
import com.example.BookApp.book.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public Optional<Venue> getVenueByName(String venueName) {
        return venueRepository.findById(venueName);
    }

    public Venue saveVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public void deleteVenue(String venueName) {
        venueRepository.deleteById(venueName);
    }
}
