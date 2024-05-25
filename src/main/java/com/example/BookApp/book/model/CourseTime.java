package com.example.BookApp.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course_times")
@IdClass(CourseTimeId.class)
public class CourseTime {

    @Id
    private Integer startTime;

    @Id
    private String venueName;

    @Id
    private String day;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "start_time", referencedColumnName = "startTime", insertable = false, updatable = false)
    private StartTime start;

    @ManyToOne
    @JoinColumn(name = "venue_name", referencedColumnName = "venueName", insertable = false, updatable = false)
    private Venue venue;
}
