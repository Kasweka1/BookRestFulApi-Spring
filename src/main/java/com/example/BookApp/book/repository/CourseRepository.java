package com.example.BookApp.book.repository;

import com.example.BookApp.book.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query("SELECT COUNT(c) FROM Course c WHERE c.courseName = ?1")
    Long countCoursesByName(String courseName);

    @Query("SELECT c FROM Course c WHERE c.courseName LIKE %?1%")
    List<Course> findCoursesByNameContaining(String name);
}
