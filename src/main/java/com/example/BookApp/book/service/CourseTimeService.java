package com.example.BookApp.book.service;

import com.example.BookApp.book.model.CourseTime;
import com.example.BookApp.book.model.CourseTimeId;
import com.example.BookApp.book.repository.CourseTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseTimeService {

    private final CourseTimeRepository courseTimeRepository;

    @Autowired
    public CourseTimeService(CourseTimeRepository courseTimeRepository) {
        this.courseTimeRepository = courseTimeRepository;
    }

    public List<CourseTime> getAllCourseTimes() {
        return courseTimeRepository.findAll();
    }

    public Optional<CourseTime> getCourseTimeById(Integer startTime, String venueName, String day) {
        return courseTimeRepository.findById(new CourseTimeId(startTime, venueName, day));
    }

    public CourseTime saveCourseTime(CourseTime courseTime) {
        return courseTimeRepository.save(courseTime);
    }

    public void deleteCourseTime(Integer startTime, String venueName, String day) {
        courseTimeRepository.deleteById(new CourseTimeId(startTime, venueName, day));
    }
}
