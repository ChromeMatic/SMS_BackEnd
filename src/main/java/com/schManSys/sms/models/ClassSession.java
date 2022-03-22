package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Table
@Entity(name="classSession")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classSessionId;
    private String className;
    @OneToOne
    private Subject subject;
    @OneToOne
    private Teacher teacher;
    @OneToMany
    private Collection<Student> students = new ArrayList<>();
}
