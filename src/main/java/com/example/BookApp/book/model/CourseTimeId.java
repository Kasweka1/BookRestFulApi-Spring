package com.example.BookApp.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseTimeId implements Serializable {

    private Integer startTime;
    private String venueName;
    private String day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTimeId that = (CourseTimeId) o;
        return Objects.equals(startTime, that.startTime) &&
                Objects.equals(venueName, that.venueName) &&
                Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, venueName, day);
    }
}
