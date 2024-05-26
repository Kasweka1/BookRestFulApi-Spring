package com.example.BookApp.book.controller;

import com.example.BookApp.book.model.StartTime;
import com.example.BookApp.book.service.StartTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/start-times")
public class StartTimeController {

    private final StartTimeService startTimeService;

    @Autowired
    public StartTimeController(StartTimeService startTimeService) {
        this.startTimeService = startTimeService;
    }

    @GetMapping
    public ResponseEntity<List<StartTime>> getAllStartTimes() {
        List<StartTime> startTimes = startTimeService.getAllStartTimes();
        return new ResponseEntity<>(startTimes, HttpStatus.OK);
    }

    @GetMapping("/{startTime}")
    public ResponseEntity<StartTime> getStartTimeById(@PathVariable("startTime") Integer startTime) {
        Optional<StartTime> startTimeOptional = startTimeService.getStartTimeById(startTime);
        if (startTimeOptional.isPresent()) {
            return new ResponseEntity<>(startTimeOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<StartTime> addStartTime(@RequestBody StartTime startTime) {
        StartTime savedStartTime = startTimeService.saveStartTime(startTime);
        return new ResponseEntity<>(savedStartTime, HttpStatus.CREATED);
    }

    @DeleteMapping("/{startTime}")
    public ResponseEntity<Void> deleteStartTime(@PathVariable("startTime") Integer startTime) {
        startTimeService.deleteStartTime(startTime);
        return ResponseEntity.noContent().build();
    }
}
