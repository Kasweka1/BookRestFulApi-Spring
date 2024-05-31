package com.example.BookApp.scheduler.controller;


import com.example.BookApp.scheduler.model.Course;
import com.example.BookApp.scheduler.model.CourseTime;
import com.example.BookApp.scheduler.model.CourseUnit;
import com.example.BookApp.scheduler.model.Stream;
import com.example.BookApp.scheduler.service.CourseService;
import com.example.BookApp.scheduler.service.CourseTimeService;
import com.example.BookApp.scheduler.service.CourseUnitService;
import com.example.BookApp.scheduler.service.StreamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private CourseUnitService courseUnitService;

    @Autowired
    private StreamService streamService;

    @Autowired
    private CourseTimeService courseTimeService;
    
   // Course endpoints
   @PostMapping("/courses")
   @ResponseStatus(HttpStatus.CREATED)
   public Course createCourse(@RequestBody Course course) {
       return courseService.saveCourse(course);
       
   }

   @GetMapping("/courses")
   @ResponseStatus(HttpStatus.OK)
   public List<Course> getAllCourses() {
       return courseService.getAllCourses();
   }

   @GetMapping("/courses/{id}")
   @ResponseStatus(HttpStatus.OK)
   public Optional<Course> getCourseById(@PathVariable Long id) {
       return courseService.getCourseById(id);
   }

   @PutMapping("/courses/{id}")
   @ResponseStatus(HttpStatus.OK)
   public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
       return courseService.saveCourse(updatedCourse);  // Update using saveCourse
   }

   @DeleteMapping("/courses/{id}")
   public void deleteCourse(@PathVariable Long id) {
       courseService.deleteCourseById(id);
   }

   // CourseUnit endpoints
    @PostMapping("/courseunits")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseUnit createCourseUnit(@RequestBody CourseUnit courseUnit) {
        return courseUnitService.saveCourseUnit(courseUnit);
    }

    @GetMapping("/courseunits")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseUnit> getAllCourseUnits() {
        return courseUnitService.getAllCourseUnits();
    }

    @GetMapping("/courseunits/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CourseUnit> getCourseUnitById(@PathVariable Long id) {
        return courseUnitService.getCourseUnitById(id);
    }

    @PutMapping("/courseunits/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseUnit updateCourseUnit(@PathVariable Long id, @RequestBody CourseUnit updatedCourseUnit) {
        return courseUnitService.saveCourseUnit(updatedCourseUnit);  // Update using saveOrUpdateCourseUnit
    }

    @DeleteMapping("/courseunits/{id}")
    public void deleteCourseUnit(@PathVariable Long id) {
        courseUnitService.deleteCourseUnitById(id);
    }

    // Stream endpoints
    @PostMapping("/streams")
    @ResponseStatus(HttpStatus.CREATED)
    public Stream createStream(@RequestBody Stream stream) {
        return streamService.saveStream(stream);
    }

    @GetMapping("/streams")
    @ResponseStatus(HttpStatus.OK)
    public List<Stream> getAllStreams() {
        return streamService.getAllStreams();
    }

    @GetMapping("/streams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Stream> getStreamById(@PathVariable Long id) {
        return streamService.getStreamById(id);
    }

    @PutMapping("/streams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stream updateStream(@PathVariable Long id, @RequestBody Stream updatedStream) {
        return streamService.saveStream(updatedStream);  // Update using saveOrUpdateStream
    }

    @DeleteMapping("/streams/{id}")
    public void deleteStream(@PathVariable Long id) {
        streamService.deleteStreamById(id);
    }

    // CourseTime endpoints
    @PostMapping("/coursetimes")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseTime createCourseTime(@RequestBody CourseTime courseTime) {
        return courseTimeService.saveCourseTime(courseTime);
    }

    @GetMapping("/coursetimes")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseTime> getAllCourseTimes() {
        return courseTimeService.getAllCourseTimes();
    }

    @GetMapping("/coursetimes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CourseTime> getCourseTimeById(@PathVariable Long id) {
        return courseTimeService.getCourseTimeById(id);
    }

    @PutMapping("/coursetimes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseTime updateCourseTime(@PathVariable Long id, @RequestBody CourseTime updatedCourseTime) {
        return courseTimeService.saveCourseTime(updatedCourseTime);  // Update using saveOrUpdateCourseTime
    }

    @DeleteMapping("/coursetimes/{id}")
    public void deleteCourseTime(@PathVariable Long id) {
        courseTimeService.deleteCourseTimeById(id);
    }
}
