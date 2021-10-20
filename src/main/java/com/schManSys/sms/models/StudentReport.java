package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentGradeId;
    @OneToOne
    private School school;
    @OneToOne
    private Student student;
    @ManyToOne
    private StudentGrades studentGrades;
    private String FinalLetterGrade;
    private Date termDate;
}
