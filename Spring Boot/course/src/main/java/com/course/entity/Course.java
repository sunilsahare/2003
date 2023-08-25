package com.course.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "course")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name", length = 255)
    private String name;

    @Column(name = "course_duration")
    private Integer duration;

    @Column(name = "course_fee")
    private Double fee;

}
