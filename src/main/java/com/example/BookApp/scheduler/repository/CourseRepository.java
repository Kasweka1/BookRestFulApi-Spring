package com.example.BookApp.scheduler.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookApp.scheduler.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

} 
