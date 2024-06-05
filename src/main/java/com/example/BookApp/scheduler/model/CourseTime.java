package com.example.BookApp.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime  time;
    private String day;
    private String venue;

    @ManyToOne
    @JoinColumn(name = "course_unit_id")
    private CourseUnit courseUnit;

    // @ManyToOne
    // @JoinColumn(name = "stream_id")
    // private Stream stream;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    @JoinTable(
        name = "course_time_stream",
        joinColumns = @JoinColumn(name = "course_time_id"),
        inverseJoinColumns = @JoinColumn(name = "stream_id")
    )
    private List<Stream> streams;
    
}
