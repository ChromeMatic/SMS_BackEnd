package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    @OneToOne
    private Subject subject;
    private String teacherName;
    private String timeAndDate;
    @OneToMany
    private List<CourseResources> courseResources = new ArrayList<>();
}
