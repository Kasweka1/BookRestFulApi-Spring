package com.example.BookApp.book.repository;

import com.example.BookApp.book.model.CourseTime;
import com.example.BookApp.book.model.CourseTimeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseTimeRepository extends JpaRepository<CourseTime, CourseTimeId> {

    @Query("SELECT COUNT(ct) FROM CourseTime ct WHERE ct.day = ?1")
    Long countCourseTimesByDay(String day);

    @Query("SELECT ct FROM CourseTime ct WHERE ct.course.courseId = ?1")
    List<CourseTime> findCourseTimesByCourseId(String courseId);

    @Query("SELECT ct FROM CourseTime ct WHERE ct.venue.venueName = ?1")
    List<CourseTime> findCourseTimesByVenueName(String venueName);
}
