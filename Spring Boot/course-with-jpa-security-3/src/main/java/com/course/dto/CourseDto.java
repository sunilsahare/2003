package com.course.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDto {

    private Integer courseId;
    private String name;
    private Integer duration;
    private Double fee;
}
