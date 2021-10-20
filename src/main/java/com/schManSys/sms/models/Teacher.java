package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Table
@Entity(name = "teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;
    @OneToOne
    private AppUser user;
    private String teacherName;
    private String Address;
    @ManyToOne
    private School school;
    @OneToMany
    private Collection<Course> courses = new ArrayList<>();
}
