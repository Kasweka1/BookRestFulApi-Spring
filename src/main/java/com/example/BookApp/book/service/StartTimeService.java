package com.example.BookApp.book.service;

import com.example.BookApp.book.model.StartTime;
import com.example.BookApp.book.repository.StartTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StartTimeService {

    private final StartTimeRepository startTimeRepository;

    @Autowired
    public StartTimeService(StartTimeRepository startTimeRepository) {
        this.startTimeRepository = startTimeRepository;
    }

    public List<StartTime> getAllStartTimes() {
        return startTimeRepository.findAll();
    }

    public Optional<StartTime> getStartTimeById(Integer startTime) {
        return startTimeRepository.findById(startTime);
    }

    public StartTime saveStartTime(StartTime startTime) {
        return startTimeRepository.save(startTime);
    }

    public void deleteStartTime(Integer startTime) {
        startTimeRepository.deleteById(startTime);
    }
}
