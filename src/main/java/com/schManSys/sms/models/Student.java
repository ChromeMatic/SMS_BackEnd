package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table
@Entity(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String studentName;
    private String dob;
    @OneToOne
    private AppUser appUser = new AppUser();
    @OneToMany
    private List<StudentGrades> gradesSet = new ArrayList<>();
    @OneToMany
    private Collection<Course> courses = new ArrayList<>();
    @OneToMany
    private List<StudentReport> studentReports = new ArrayList<>();
    @OneToMany
    private  List<StudentContactInfo> info = new ArrayList<>();
}
