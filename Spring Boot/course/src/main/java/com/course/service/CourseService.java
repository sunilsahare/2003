package com.course.service;

import com.course.dto.CourseDto;

import java.util.List;

public interface CourseService {

    public CourseDto addCourse(CourseDto course);

    public List<CourseDto> getAllCourses();

    public CourseDto getCourse(Integer courseId);

    public void deleteCourse(Integer courseId);

    public CourseDto updateCourse(CourseDto course);
}
