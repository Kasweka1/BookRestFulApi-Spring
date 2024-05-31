package com.example.BookApp.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookApp.scheduler.model.CourseTime;

public interface CourseTimeRepository extends JpaRepository<CourseTime, Long>{
    
}
