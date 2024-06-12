package com.example.BookApp.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookApp.scheduler.model.CourseUnit;

public interface CourseUnitRepository extends JpaRepository<CourseUnit, Long>{
    
}
