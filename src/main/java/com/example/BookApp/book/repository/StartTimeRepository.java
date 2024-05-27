package com.example.BookApp.book.repository;

import com.example.BookApp.book.model.StartTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StartTimeRepository extends JpaRepository<StartTime, Integer> {

    @Query("SELECT COUNT(s) FROM StartTime s WHERE s.startTime = ?1")
    Long countStartTimesByStartTime(Integer startTime);

    @Query("SELECT s FROM StartTime s WHERE s.startTime >= ?1")
    List<StartTime> findStartTimesAfter(Integer startTime);
}
