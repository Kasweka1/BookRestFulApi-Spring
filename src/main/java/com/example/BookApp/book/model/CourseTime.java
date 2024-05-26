package com.example.BookApp.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;

@Entity
@Table(name = "course_times")
public class CourseTime {

    @Column(name = "course_id")
    private String courseID;

    @Id
    @Column(name = "start_time")
    private String startTime;

    @Id
    @Column(name = "venue_name")
    private String venueName;

    @Id
    @Column(name = "day")
    private String day;

    // Constructors
    public CourseTime() {
    }

    public CourseTime(String courseID, String startTime, String venueName, String day) {
        this.courseID = courseID;
        this.startTime = startTime;
        this.venueName = venueName;
        this.day = day;
    }

    // Getters and Setters
    public String getCourseID() {
        return courseID;
    }

    public void setId(String courseID) {
        this.courseID = courseID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    @Override
    public String toString() {
        return "CourseTime{" +
                "courseID=" + courseID +
                ", startTime='" + startTime + '\'' +
                ", day='" + day + '\'' +
                ", venueName='" + venueName + '\'' +
                '}';
    }
}
