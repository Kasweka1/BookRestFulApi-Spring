package com.example.BookApp.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookApp.scheduler.model.Stream;

public interface StreamRepository extends JpaRepository<Stream, Long>{
    
}
