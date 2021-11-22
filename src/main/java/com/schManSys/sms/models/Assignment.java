package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity(name = "assignment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assignmentID;
    private String assignmentNme;
    @OneToOne
    private Course course;
    private String DueDate;
    private String assignment;
}
