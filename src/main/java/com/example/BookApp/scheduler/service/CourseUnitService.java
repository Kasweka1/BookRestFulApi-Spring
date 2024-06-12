package com.example.BookApp.scheduler.service;

import com.example.BookApp.scheduler.model.CourseUnit;
import com.example.BookApp.scheduler.repository.CourseUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseUnitService {
    @Autowired
    private CourseUnitRepository courseUnitRepository;

    // Save or update a CourseUnit
    public CourseUnit saveCourseUnit(CourseUnit courseUnit) {
        return courseUnitRepository.save(courseUnit);
    }

    // Retrieve all CourseUnits
    public List<CourseUnit> getAllCourseUnits() {
        return courseUnitRepository.findAll();
    }

    // Retrieve a CourseUnit by ID
    public Optional<CourseUnit> getCourseUnitById(Long id) {
        return courseUnitRepository.findById(id);
    }

    // Delete a CourseUnit by ID
    public void deleteCourseUnitById(Long id) {
        courseUnitRepository.deleteById(id);
    }
}
