package com.course.helper;

import com.course.dto.CourseDto;
import com.course.entity.Course;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class CourseHelper {

    private CourseHelper(){}


    public static Course dtoToEntity(CourseDto course) {
        return Course.builder()
                .fee(course.getFee())
                .name(course.getName())
                .duration(course.getDuration())
                .id(0)
                .build();
    }

    public static CourseDto entityToDto(Course savedCourse) {
        return CourseDto.builder()
                .fee(savedCourse.getFee())
                .name(savedCourse.getName())
                .duration(savedCourse.getDuration())
                .courseId(savedCourse.getId())
                .build();
    }

    public static List<CourseDto> entityListToDto(List<Course> courseList) {
        return courseList.stream()
                .map(CourseHelper::entityToDto)
                .collect(Collectors.toList());
    }

    public static List<Course> dtoListToEntity(List<CourseDto> courseList) {
        return courseList.stream()
                .map(CourseHelper::dtoToEntity)
                .collect(Collectors.toList());
    }


}
