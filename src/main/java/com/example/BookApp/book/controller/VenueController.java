package com.example.BookApp.book.controller;

import com.example.BookApp.book.model.Venue;
import com.example.BookApp.book.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    private final VenueService venueService;

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public ResponseEntity<List<Venue>> getAllVenues() {
        List<Venue> venues = venueService.getAllVenues();
        return new ResponseEntity<>(venues, HttpStatus.OK);
    }

    @GetMapping("/{venueName}")
    public ResponseEntity<Venue> getVenueByName(@PathVariable("venueName") String venueName) {
        Optional<Venue> venueOptional = venueService.getVenueByName(venueName);
        if (venueOptional.isPresent()) {
            return new ResponseEntity<>(venueOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Venue> addVenue(@RequestBody Venue venue) {
        Venue savedVenue = venueService.saveVenue(venue);
        return new ResponseEntity<>(savedVenue, HttpStatus.CREATED);
    }

    @DeleteMapping("/{venueName}")
    public ResponseEntity<Void> deleteVenue(@PathVariable("venueName") String venueName) {
        venueService.deleteVenue(venueName);
        return ResponseEntity.noContent().build();
    }
}
