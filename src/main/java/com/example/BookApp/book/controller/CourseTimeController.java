package com.example.BookApp.book.controller;

import com.example.BookApp.book.model.CourseTime;
import com.example.BookApp.book.model.CourseTimeId;
import com.example.BookApp.book.service.CourseTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course-times")
public class CourseTimeController {

    private final CourseTimeService courseTimeService;

    @Autowired
    public CourseTimeController(CourseTimeService courseTimeService) {
        this.courseTimeService = courseTimeService;
    }

    @GetMapping
    public ResponseEntity<List<CourseTime>> getAllCourseTimes() {
        List<CourseTime> courseTimes = courseTimeService.getAllCourseTimes();
        return new ResponseEntity<>(courseTimes, HttpStatus.OK);
    }

    @GetMapping("/{startTime}/{venueName}/{day}")
    public ResponseEntity<CourseTime> getCourseTimeById(
            @PathVariable("startTime") Integer startTime,
            @PathVariable("venueName") String venueName,
            @PathVariable("day") String day) {
        Optional<CourseTime> courseTimeOptional = courseTimeService.getCourseTimeById(startTime, venueName, day);
        if (courseTimeOptional.isPresent()) {
            return new ResponseEntity<>(courseTimeOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CourseTime> addCourseTime(@RequestBody CourseTime courseTime) {
        CourseTime savedCourseTime = courseTimeService.saveCourseTime(courseTime);
        return new ResponseEntity<>(savedCourseTime, HttpStatus.CREATED);
    }

    @DeleteMapping("/{startTime}/{venueName}/{day}")
    public ResponseEntity<Void> deleteCourseTime(
            @PathVariable("startTime") Integer startTime,
            @PathVariable("venueName") String venueName,
            @PathVariable("day") String day) {
        courseTimeService.deleteCourseTime(startTime, venueName, day);
        return ResponseEntity.noContent().build();
    }
}
