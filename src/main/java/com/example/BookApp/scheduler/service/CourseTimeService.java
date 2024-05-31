package com.example.BookApp.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BookApp.scheduler.model.CourseTime;
import com.example.BookApp.scheduler.model.CourseUnit;
import com.example.BookApp.scheduler.repository.CourseTimeRepository;
import com.example.BookApp.scheduler.repository.CourseUnitRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseTimeService {

   @Autowired
    private CourseTimeRepository courseTimeRepository;

    // Save or update a CourseTime
    public CourseTime saveCourseTime(CourseTime courseTime) {
        return courseTimeRepository.save(courseTime);
    }

    // Retrieve all CourseTimes
    public List<CourseTime> getAllCourseTimes() {
        return courseTimeRepository.findAll();
    }

    // Retrieve a CourseTime by ID
    public Optional<CourseTime> getCourseTimeById(Long id) {
        return courseTimeRepository.findById(id);
    }

    // Delete a CourseTime by ID
    public void deleteCourseTimeById(Long id) {
        courseTimeRepository.deleteById(id);
    }
}
