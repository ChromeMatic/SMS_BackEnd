package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name = "studentGrades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGrades {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentGradeId;
    private String studentName;
    private String subjectName;
    private String TestName;
    private String letterGarde;
    private String marks;
    private Date date;
}
