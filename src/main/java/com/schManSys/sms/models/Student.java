package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
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
    private Long studentGradeId;
    @OneToOne
    private AppUser appUser;
    @ManyToOne
    private  School school;
    @OneToMany
    private List<StudentGrades> gradesSet = new ArrayList<>();
    @OneToMany
    private List<Course> courses = new ArrayList<>();
    @OneToMany
    private List<StudentReport> studentReports = new ArrayList<>();
    @OneToMany
    private  List<StudentContactInfo> info = new ArrayList<>();
}
