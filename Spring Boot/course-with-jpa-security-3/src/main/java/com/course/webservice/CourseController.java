package com.course.webservice;

import com.course.dto.CourseDto;
import com.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto course) {
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping("/course")
    public ResponseEntity<List<CourseDto>> getCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Integer courseId) {
        return ResponseEntity.ok(courseService.getCourse(courseId));
    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<String> removeCourse(@PathVariable Integer courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("Course Successfully Deleted.");
    }

    @PutMapping("/course/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(
            @PathVariable Integer courseId, @RequestBody CourseDto course) {
        course.setCourseId(courseId);
        return ResponseEntity.ok(courseService.updateCourse(course));
    }

}
