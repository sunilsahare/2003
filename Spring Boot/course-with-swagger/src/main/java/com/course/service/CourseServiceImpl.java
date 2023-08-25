package com.course.service;

import com.course.dto.CourseDto;
import com.course.entity.Course;
import com.course.exception.CourseNotFoundException;
import com.course.helper.CourseHelper;
import com.course.repo.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        Course course = CourseHelper.dtoToEntity(courseDto);
        // Add Some Validation Here
        Course savedCourse = courseRepository.save(course);
        return CourseHelper.entityToDto(savedCourse);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        return CourseHelper.entityListToDto(courseList);
    }

    @Override
    public CourseDto getCourse(Integer courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course N0t found - " + courseId));
        return CourseHelper.entityToDto(course);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course NOt found - " + courseId));
        courseRepository.delete(course);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        Course course = courseRepository.findById(courseDto.getCourseId()).orElseThrow(() -> new CourseNotFoundException("Course NOt found - " + courseDto.getCourseId()));
        course.setDuration(courseDto.getDuration());
        course.setFee(courseDto.getFee());
        course.setName(courseDto.getName());
        Course updatedCourse = courseRepository.save(course);
        return CourseHelper.entityToDto(updatedCourse);
    }
}
