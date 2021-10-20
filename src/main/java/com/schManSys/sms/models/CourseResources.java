package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity(name = "courseResources")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResources {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseResourceId;
}
