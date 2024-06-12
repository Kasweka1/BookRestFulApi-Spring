package com.example.BookApp.scheduler.service;

import com.example.BookApp.scheduler.model.Course;
import com.example.BookApp.scheduler.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    // Save or update a course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Retrieve a course by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Delete a course by ID
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    
}
